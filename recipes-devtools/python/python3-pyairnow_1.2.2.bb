SUMMARY = "A lightweight Python wrapper for EPA AirNow Air Quality API"
HOMEPAGE = "https://github.com/asymworks/pyairnow"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d867984564a4e043b6c395e4826752f2"

SRC_URI[sha256sum] = "643d0de6e1e7d18b6547410bf2f39a3bb3c12c0d7e24e6bf15c5f4ddad650071"

inherit pypi python_poetry_core

PYPI_PACKAGE = "pyairnow"
RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.8.3) \
"
