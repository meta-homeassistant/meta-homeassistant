SUMMARY = "A utility for mocking out the Python HTTPX and HTTP Core libraries."
HOMEPAGE = "https://lundberg.github.io/respx/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=8c1e10a26712c34121879d038786a67b"

SRC_URI[sha256sum] = "0bd7fe21bfaa52106caa1223ce61224cf30786985f17c63c5d71eff0307ee8af"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-httpx \
"
PYPI_PACKAGE = "respx"
