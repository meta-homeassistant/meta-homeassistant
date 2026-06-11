#!/bin/bash
set -euo pipefail

if [ "$#" -lt 1 ]; then
    echo "Usage: $0 <recipe-name> [machine]"
    exit 2
fi

RECIPE="$1"
MACHINE="qemux86-64"
if [ $# -ge 2 ]; then
    MACHINE="$2"
fi

# Resolve workspace root (script lives in tests/)
ROOT="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"

LOG_FILE="${ROOT}/ptest-run.log"
QEMU_PID_FILE="ptest-qemu.pid"

QEMU_CONF="${ROOT}/bitbake-builds/homeassistant-x86/build/tmp/deploy/images/${MACHINE}/core-image-homeassistant-full-qemux86-64-1.0.0.qemuboot.conf"

SSH_USER="root"
SSH_PORT=2222
SSH_OPTS="-o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null -o LogLevel=ERROR -p $SSH_PORT"

cleanup() {
    echo "Cleaning up QEMU..." | tee -a "$LOG_FILE"
    if [ -f "$QEMU_PID_FILE" ]; then
        kill "$(cat "$QEMU_PID_FILE")" 2>/dev/null || true
        rm -f "$QEMU_PID_FILE"
    fi
}
trap cleanup EXIT

# 1. Temporarily disable 'set -u' to avoid unbound variable error, then source Yocto environment and cd to workspace root
set +u
source bitbake-builds/homeassistant-x86/build/init-build-env
set -u
cd "$ROOT"

echo "Starting ptest run for recipe: $RECIPE (machine: $MACHINE)" | tee "$LOG_FILE"
echo "Using QEMU config: $QEMU_CONF" | tee -a "$LOG_FILE"

if [ ! -f "$QEMU_CONF" ]; then
    echo "QEMU config not found: $QEMU_CONF" | tee -a "$LOG_FILE"
    exit 1
fi
# 2. Start QEMU with runqemu in the background, log output to qemu.log
echo "Launching QEMU (headless) and logging to $LOG_FILE..." | tee -a "$LOG_FILE"
runqemu "$QEMU_CONF" slirp kvm nographic snapshot >>"$LOG_FILE" 2>&1 &
QEMU_TERM_PID=$!
echo $QEMU_TERM_PID > "$QEMU_PID_FILE"

sleep 5

echo "Waiting for SSH to become available..." | tee -a "$LOG_FILE"
for i in {1..60}; do
    if ssh $SSH_OPTS $SSH_USER@localhost 'echo ok' 2>/dev/null | grep -q ok; then
        echo "SSH is up." | tee -a "$LOG_FILE"
        break
    fi
    sleep 2
done

PTEST_DIR="/usr/lib/${RECIPE}/ptest"
echo "Changing to ptest dir: $PTEST_DIR and preparing run-ptest" | tee -a "$LOG_FILE"

# Run commands on target: back up `run-ptest`, remove `--automake` in-place, make executable, run it in-place; capture all output
set +e
ssh $SSH_OPTS $SSH_USER@localhost "cd \"$PTEST_DIR\" && if [ -f run-ptest ]; then cp run-ptest run-ptest.bak && sed -i 's/--automake//g' run-ptest && chmod +x run-ptest && ./run-ptest; else echo 'ERROR: run-ptest not found in $PTEST_DIR' >&2; fi" >>"$LOG_FILE" 2>&1
PTEST_EXIT=$?
set -e

echo "run-ptest exit code: $PTEST_EXIT" | tee -a "$LOG_FILE"

if [ $PTEST_EXIT -ne 0 ]; then
    echo "ptest run failed with exit code $PTEST_EXIT" | tee -a "$LOG_FILE"
fi

exit $PTEST_EXIT
