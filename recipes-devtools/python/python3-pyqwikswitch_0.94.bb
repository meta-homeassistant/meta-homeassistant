SUMMARY = "Library to interface Qwikswitch USB Hub"
HOMEPAGE = "https://github.com/kellerza/pyqwikswitch"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=01477b5b3c48858793fa0f56de455f9f"

SRC_URI[sha256sum] = "229c96cfedc432bd08fb150b04926106076740734f2483354aa2852e9b338507"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-attrs \
    python3-requests \
"

PYPI_PACKAGE = "pyqwikswitch"
