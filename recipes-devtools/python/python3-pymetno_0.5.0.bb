LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-3.0;md5=c79ff39f19dfec6d293b95dea7b07891"

inherit pypi setuptools3

SRC_URI = "https://files.pythonhosted.org/packages/source/p/pymetno/PyMetno-${PV}.tar.gz"

S = "${WORKDIR}/PyMetno-${PV}"

SRC_URI[md5sum] = "9fe0910f68c0f04080f3228cca9ab0f4"
SRC_URI[sha256sum] = "e532544495200210407e3d68f719c271435da6f3bfe696e708b1d5d603a21948"

RDEPENDS_${PN} = "\
	${PYTHON_PN}-aiohttp (>=3.6.1) \
	${PYTHON_PN}-async-timeout (>=3.0.1) \
	${PYTHON_PN}-pytz (>=2019.3) \
"
