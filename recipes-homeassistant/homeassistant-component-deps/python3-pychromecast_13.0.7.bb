SUMMARY = "Library for Python 3 to communicate with the Google Chromecast."
HOMEPAGE = "https://github.com/home-assistant-libs/pychromecast"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1dbd4e85f47b389bdadee9c694669f5"

SRC_URI[sha256sum] = "0de98e9e5be43269dd41efb16126ab0d5ba941ca4acae024329712851c0c0324"

PYPI_PACKAGE = "PyChromecast"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-casttube (>=0.2.0)) \
    ${PYTHON_PN}-protobuf (>=3.19.1) \
    ${PYTHON_PN}-zeroconf (>=0.25.1) \
"
