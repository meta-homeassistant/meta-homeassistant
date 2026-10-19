#!/usr/bin/env bash
set -euo pipefail

usage() {
    cat <<'EOF'
Usage: tests/image/test-pytest-plain.sh --wrapper <wrapper> --target <image>
                                 (--package <package> | --ptest-dir <guest-path>)
                                 [--setup-dir <path>] [--machine <machine>]
                                 [--ssh-user <user>] [--ssh-port <port>]
                                 [--log-dir <path>] [--no-default-runqemu-args]
                                 [--runqemu-arg <arg>...]

Legacy layer-local form remains available:
    tests/image/test-pytest-plain.sh <package> [machine]
EOF
}

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
LAYER_ROOT="$(cd "${SCRIPT_DIR}/../.." && pwd)"
WRAPPER=""
TARGET=""
PACKAGE=""
PTEST_DIR=""
SETUP_DIR=""
MACHINE_OVERRIDE=""
SSH_USER="root"
SSH_PORT="2222"
LOG_DIR="${PYTEST_PLAIN_LOG_DIR:-${LAYER_ROOT}/test-logs}"
USE_DEFAULT_RUNQEMU_ARGS="yes"
LEGACY_ARGS=()
declare -a EXTRA_RUNQEMU_ARGS=()

if [[ $# -gt 0 && "$1" != -* ]]; then
    LEGACY_ARGS=("$@")
    if [[ ${#LEGACY_ARGS[@]} -gt 2 ]]; then
        echo "ERROR: legacy form accepts only <package> [machine]" >&2
        exit 2
    fi
    PACKAGE="${LEGACY_ARGS[0]}"
    MACHINE_OVERRIDE="${LEGACY_ARGS[1]:-}"
    WRAPPER="${HA_PTEST_WRAPPER:-homeassistant-x86}"
    TARGET="${HA_PTEST_TARGET:-core-image-homeassistant-full}"
else
    while [[ $# -gt 0 ]]; do
        case "$1" in
            --wrapper|--target|--package|--ptest-dir|--setup-dir|--machine|--ssh-user|--ssh-port|--log-dir|--runqemu-arg)
                [[ $# -ge 2 ]] || { echo "ERROR: $1 requires a value" >&2; exit 2; }
                case "$1" in
                    --wrapper) WRAPPER="$2" ;;
                    --target) TARGET="$2" ;;
                    --package) PACKAGE="$2" ;;
                    --ptest-dir) PTEST_DIR="$2" ;;
                    --setup-dir) SETUP_DIR="$2" ;;
                    --machine) MACHINE_OVERRIDE="$2" ;;
                    --ssh-user) SSH_USER="$2" ;;
                    --ssh-port) SSH_PORT="$2" ;;
                    --log-dir) LOG_DIR="$2" ;;
                    --runqemu-arg) EXTRA_RUNQEMU_ARGS+=("$2") ;;
                esac
                shift 2
                ;;
            --no-default-runqemu-args)
                USE_DEFAULT_RUNQEMU_ARGS="no"
                shift
                ;;
            -h|--help)
                usage
                exit 0
                ;;
            *)
                echo "ERROR: unknown argument '$1'" >&2
                usage >&2
                exit 2
                ;;
        esac
    done
fi

if [[ -z "${WRAPPER}" || -z "${TARGET}" ]]; then
    echo "ERROR: both --wrapper and --target are required" >&2
    usage >&2
    exit 2
fi
if [[ -n "${PACKAGE}" && -n "${PTEST_DIR}" ]]; then
    echo "ERROR: provide only one of --package and --ptest-dir" >&2
    exit 2
fi
if [[ -z "${PACKAGE}" && -z "${PTEST_DIR}" ]]; then
    echo "ERROR: provide either --package or --ptest-dir" >&2
    usage >&2
    exit 2
fi
if [[ -n "${PACKAGE}" && ! "${PACKAGE}" =~ ^[A-Za-z0-9_.+-]+$ ]]; then
    echo "ERROR: invalid package name '${PACKAGE}'" >&2
    exit 2
fi
if [[ -n "${PTEST_DIR}" && "${PTEST_DIR}" != /* ]]; then
    echo "ERROR: --ptest-dir must be an absolute guest path" >&2
    exit 2
fi
if [[ ! "${SSH_PORT}" =~ ^[0-9]+$ ]] || (( SSH_PORT < 1 || SSH_PORT > 65535 )); then
    echo "ERROR: invalid SSH port '${SSH_PORT}'" >&2
    exit 2
fi
if [[ -z "${PTEST_DIR}" ]]; then
    PTEST_DIR="/usr/lib/${PACKAGE}/ptest"
fi

if [[ -z "${SETUP_DIR}" ]]; then
    SETUP_DIR="${LAYER_ROOT}/bitbake-builds/${WRAPPER}"
    if [[ ! -f "${SETUP_DIR}/build/init-build-env" ]]; then
        current_dir="${LAYER_ROOT}"
        while [[ "${current_dir}" != / ]]; do
            if [[ -f "${current_dir}/bitbake-builds/${WRAPPER}/build/init-build-env" ]]; then
                SETUP_DIR="${current_dir}/bitbake-builds/${WRAPPER}"
                break
            fi
            current_dir="$(dirname "${current_dir}")"
        done
    fi
fi
INIT_SCRIPT="${SETUP_DIR}/build/init-build-env"
if [[ ! -f "${INIT_SCRIPT}" ]]; then
    echo "ERROR: init-build-env not found at ${INIT_SCRIPT}; pass --setup-dir" >&2
    exit 1
fi

set +u
# shellcheck disable=SC1090
source "${INIT_SCRIPT}"
set -u

if [[ -z "${BUILDDIR:-}" ]]; then
    echo "ERROR: BUILDDIR not set after sourcing build environment" >&2
    exit 1
fi
if ! command -v runqemu >/dev/null 2>&1; then
    echo "ERROR: runqemu not found in PATH after sourcing build environment" >&2
    exit 1
fi

MACHINE="${MACHINE_OVERRIDE:-${MACHINE:-}}"
if [[ -z "${MACHINE}" ]]; then
    shopt -s nullglob
    machine_dirs=("${BUILDDIR}/tmp/deploy/images"/*)
    shopt -u nullglob
    if [[ ${#machine_dirs[@]} -ne 1 ]]; then
        echo "ERROR: could not determine MACHINE from ${BUILDDIR}/tmp/deploy/images" >&2
        exit 1
    fi
    MACHINE="$(basename "${machine_dirs[0]}")"
fi

mkdir -p "${LOG_DIR}"
RUN_ID="$(date +%Y%m%d-%H%M%S)-$$"
PYTEST_LOG="${LOG_DIR}/pytest-${WRAPPER}-${RUN_ID}.log"
QEMU_LOG="${LOG_DIR}/qemu-${WRAPPER}-${RUN_ID}.log"
SSH_OPTS=(-o StrictHostKeyChecking=no -o UserKnownHostsFile=/dev/null -o LogLevel=ERROR -p "${SSH_PORT}")
QEMU_PID=""

cleanup() {
    if [[ -n "${QEMU_PID}" ]]; then
        kill "${QEMU_PID}" 2>/dev/null || true
        wait "${QEMU_PID}" 2>/dev/null || true
    fi
}
trap cleanup EXIT
trap 'exit 130' INT
trap 'exit 143' TERM

wait_for_ssh() {
    local attempt
    for attempt in {1..60}; do
        if ssh "${SSH_OPTS[@]}" "${SSH_USER}@localhost" 'echo ok' 2>/dev/null | grep -q ok; then
            return 0
        fi
        if ! kill -0 "${QEMU_PID}" 2>/dev/null; then
            wait "${QEMU_PID}" 2>/dev/null || true
            return 1
        fi
        sleep 2
    done
    return 1
}

RUNQEMU_ARGS=()
if [[ "${USE_DEFAULT_RUNQEMU_ARGS}" == yes ]]; then
    RUNQEMU_ARGS+=(slirp kvm wic snapshot nographic)
    if [[ "${MACHINE}" == qemux86-64* ]]; then
        RUNQEMU_ARGS+=(ovmf.code ovmf.vars)
    fi
fi
RUNQEMU_ARGS+=("${EXTRA_RUNQEMU_ARGS[@]}")

echo "Booting ${TARGET} with ${WRAPPER} (MACHINE=${MACHINE})"
printf 'runqemu args:'
printf ' %q' "${TARGET}" "${RUNQEMU_ARGS[@]}"
printf '\n'
runqemu "${TARGET}" "${RUNQEMU_ARGS[@]}" >"${QEMU_LOG}" 2>&1 &
QEMU_PID=$!

echo "Waiting for SSH on localhost:${SSH_PORT}..."
if ! wait_for_ssh; then
    echo "ERROR: SSH did not become available; QEMU output: ${QEMU_LOG}" >&2
    exit 1
fi

echo "Running ptest from ${PTEST_DIR} with plain pytest output"
ssh "${SSH_OPTS[@]}" "${SSH_USER}@localhost" bash -s -- "${PTEST_DIR}" <<'REMOTE' | tee "${PYTEST_LOG}"
set -euo pipefail
ptest_dir="$1"
if [[ ! -f "${ptest_dir}/run-ptest" ]]; then
    echo "ERROR: ${ptest_dir}/run-ptest not found" >&2
    exit 1
fi
cd "${ptest_dir}"
sed 's/--automake//g' run-ptest | sh
REMOTE

echo "Plain pytest output saved to ${PYTEST_LOG}"
