#!/usr/bin/env bash

# This tests all layer packages which are in ptest-packagelists-meta-homeassistant.inc and enabled

set -euo pipefail

# If --source is passed as the first argument, source the Yocto environment before running the test.
SOURCE="no"
if [ "$#" -ge 1 ] && [ "$1" = "--source" ]; then
    SOURCE="yes"
    shift
fi


if [ "$SOURCE" = "yes" ]; then
    set +u
    source "$(dirname "${BASH_SOURCE[0]}")/../bitbake-builds/homeassistant-x86/build/init-build-env"
    set -u
fi

# Enable the testing fragment, build the image, and disable the fragment again.
bitbake-config-build enable-fragment homeassistant/enable-testing-base
bitbake meta-homeassistant-image-ptest-all
bitbake-config-build disable-fragment homeassistant/enable-testing-base
