SUMMARY = "Library for Python 2 and 3 to communicate with the Google Chromecast."
HOMEPAGE = "https://github.com/balloob/pychromecast"
LICENSE = "MIT"
SRCNAME = "PyChromecast"

LIC_FILES_CHKSUM = "file://LICENSE;md5=b1dbd4e85f47b389bdadee9c694669f5"

inherit pypi

SRC_URI = "https://files.pythonhosted.org/packages/source/p/pychromecast/${SRCNAME}-${PV}.tar.gz"
SRC_URI[md5sum] = "c890fde89cf9036e3982e09181998c32"
SRC_URI[sha256sum] = "6691145bd1f761412b297af94c3a7e82f1a8872eb5f4208e6156b802eeefdd4e"

S = "${WORKDIR}/PyChromecast-${PV}"

RDEPENDS_${PN} = "\
               ${PYTHON_PN}-requests \
"
