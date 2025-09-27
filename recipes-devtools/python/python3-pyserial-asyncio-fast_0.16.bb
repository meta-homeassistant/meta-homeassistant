SUMMARY = "Python Serial Port Extension - Asynchronous I/O support"
HOMEPAGE = "https://github.com/home-assistant-libs/pyserial-asyncio-fast"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=9a79418f241689e78034391d51162d24"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "fd52643380406739d777014b0aea0873d756b542eb62f7556567239cec007115"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "python3-pyserial"

PYPI_PACKAGE = "pyserial_asyncio_fast"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

PTEST_PYTEST_DIR = "test"
