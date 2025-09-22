SUMMARY = "Python client for the airtouch 5"
HOMEPAGE = "https://github.com/danzel/airtouch5py"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI[sha256sum] = "6535738430e845a9111c4806c4c71515743f631c09de5f7f86b4b8d150576ca4"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-bitarray (>=3.4.2) \
    python3-crc (>=7.1.0) \
"

PYPI_PACKAGE = "airtouch5py"
