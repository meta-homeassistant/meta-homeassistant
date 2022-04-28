LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit pypi setuptools3

SRC_URI = "https://files.pythonhosted.org/packages/source/p/pymetno/PyMetno-${PV}.tar.gz"

S = "${WORKDIR}/PyMetno-${PV}"

SRC_URI[md5sum] = "9fe0910f68c0f04080f3228cca9ab0f4"
SRC_URI[sha256sum] = "e532544495200210407e3d68f719c271435da6f3bfe696e708b1d5d603a21948"

RDEPENDS:${PN} = "\
	${PYTHON_PN}-aiohttp (>=3.6.1) \
	${PYTHON_PN}-async-timeout (>=3.0.1) \
	${PYTHON_PN}-pytz (>=2019.3) \
"
