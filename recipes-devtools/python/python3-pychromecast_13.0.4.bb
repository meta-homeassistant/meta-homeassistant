SUMMARY = "Library for Python 3 to communicate with the Google Chromecast."
HOMEPAGE = "https://github.com/home-assistant-libs/pychromecast"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b1dbd4e85f47b389bdadee9c694669f5"

SRC_URI[md5sum] = "e9c33fd1bbc60c2a34bbd55ea972c2d5"
SRC_URI[sha256sum] = "792fba3f31e4968a5e99c19c771774083a2aa7e897ebf6f5e218e308e33a461f"

PYPI_PACKAGE = "PyChromecast"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-casttube (>=0.2.0)) \
    ${PYTHON_PN}-protobuf (>=3.19.1) \
    ${PYTHON_PN}-zeroconf (>=0.25.1) \
"
