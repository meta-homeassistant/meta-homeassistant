#!/usr/bin/env bash
set -euo pipefail

cd "$(dirname "${BASH_SOURCE[0]}")/.."
export OELINT_CONFIG="$PWD/.oelint.cfg"
export OELINT_SKIP_CONFIG=""

git ls-files -z --cached --others --exclude-standard -- \
    '*.bb' '*.bbappend' '*.bbclass' '*.inc' '*.conf' ':!:sources/**' |
    xargs -0 -r oelint-adv --quiet --relpaths --color
