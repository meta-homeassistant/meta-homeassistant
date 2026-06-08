#!/usr/bin/env bash
set -euo pipefail

set +u
source "$(dirname "${BASH_SOURCE[0]}")/../bitbake-builds/homeassistant-x86/build/init-build-env"
set -u

# Enable the testing fragment, build the image, and disable the fragment again.
bitbake-config-build enable-fragment homeassistant/enable-testing-base
bitbake core-image-homeassistant-full
bitbake-config-build disable-fragment homeassistant/enable-testing-base
