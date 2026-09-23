#!/usr/bin/env bash
set -euo pipefail

# If --source is passed as the first argument, source the Yocto environment before running the test.
SOURCE="no"
if [ "$#" -ge 1 ] && [ "$1" = "--source" ]; then
    SOURCE="yes"
    shift
fi


if [ "$SOURCE" = "yes" ]; then
    set +u
    TEST_DIR="$(dirname "${BASH_SOURCE[0]}")"
    INIT_SCRIPT="${TEST_DIR}/../bitbake-builds/homeassistant-x86/build/init-build-env"
    if [ ! -f "$INIT_SCRIPT" ]; then
        INIT_SCRIPT="${TEST_DIR}/../../../bitbake-builds/homeassistant-x86/build/init-build-env"
    fi
    source "$INIT_SCRIPT"
    set -u
fi

# Enable the testing fragment, build the image, and disable the fragment again.
bitbake-config-build enable-fragment homeassistant/enable-testing-base
bitbake-config-build enable-fragment homeassistant/add-homeassistant-image-test-deps
bitbake core-image-homeassistant-full
bitbake-config-build disable-fragment homeassistant/enable-testing-base
bitbake-config-build disable-fragment homeassistant/add-homeassistant-image-test-deps
