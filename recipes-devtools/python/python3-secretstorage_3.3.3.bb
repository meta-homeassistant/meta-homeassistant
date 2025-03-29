SUMMARY = "Python bindings to FreeDesktop.org Secret Service API"
HOMEPAGE = "https://github.com/mitya57/secretstorage"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c49a7ec562572351456ea021b15dc882"

SRC_URI[sha256sum] = "2403533ef369eca6d2ba81718576c5e0f564d5cca1b58f73a8b23e7d4eeebd77"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-cryptography \
    python3-jeepney \
"

PYPI_PACKAGE = "SecretStorage"
