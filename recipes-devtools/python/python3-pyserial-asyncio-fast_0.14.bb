SUMMARY = "Python Serial Port Extension - Asynchronous I/O support"
HOMEPAGE = "https://github.com/home-assistant-libs/pyserial-asyncio-fast"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=9a79418f241689e78034391d51162d24"

SRC_URI[sha256sum] = "09ad7f2886969da3df064e93fd47ceab47ad91144ec80e103c5cf97bb0038908"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-pyserial"

PYPI_PACKAGE = "pyserial-asyncio-fast"
