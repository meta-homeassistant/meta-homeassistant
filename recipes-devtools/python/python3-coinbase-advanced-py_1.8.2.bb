SUMMARY = "Coinbase Advanced API Python SDK"
HOMEPAGE = "https://github.com/coinbase/coinbase-advanced-py"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=ca718a534544a4a08e7b48e256072a32"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-Fix-compilation.patch"
SRC_URI[sha256sum] = "91d4550354886a05b169c6f6a44e177096d16412cb6e74f7c10ee8ff76a8dc21"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-pyjwt (>=2.8.0) \
    python3-backoff (>=2.2.1) \
    python3-cryptography (>=42.0.4) \
    python3-requests (>=2.31.0) \
    python3-websockets (>=12.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-requests-mock (>=1.11.0) \
    python3-asynctest (>=0.13.0) \
"

PYPI_PACKAGE = "coinbase-advanced-py"
