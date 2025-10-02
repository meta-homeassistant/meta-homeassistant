SUMMARY = "Python bindings for the Elvia API"
HOMEPAGE = "https://github.com/andersem/elvia-python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=83dee730c7e66b119912fd2585466342"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "cd4362cf85d78a068783b55abcdd90fe83f83fbf99ce8ed26ee33a3a065c7b0b"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.8) \
    python3-typing-extensions (>=3.10) \
"

PYPI_PACKAGE = "elvia"
