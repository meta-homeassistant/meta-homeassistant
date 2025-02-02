SUMMARY = "Python API for interacting with luftdaten.info"
HOMEPAGE = "https://github.com/home-assistant-ecosystem/python-luftdaten"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=af54c6901f696d66b284310e3d95a9cf"

SRC_URI[sha256sum] = "08f6f352e794a104eb9ceea9416f229bc68fceb895ed6a9096ba126f93cfbf04"

inherit pypi python_poetry_core

PYPI_PACKAGE = "luftdaten"
RDEPENDS:${PN} = "python3-httpx (>=0.23)"
