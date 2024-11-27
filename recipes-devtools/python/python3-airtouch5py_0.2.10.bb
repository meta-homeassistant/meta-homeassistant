SUMMARY = "Python client for the airtouch 5"
HOMEPAGE = "https://github.com/danzel/airtouch5py"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI[sha256sum] = "0d9f0f100a34148025429eff39831e7d62303e820fa2da1a53716106230bc843"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-bitarray (>=2.8.0) \
    python3-crc (>=4.3.0) \
"

PYPI_PACKAGE = "airtouch5py"
