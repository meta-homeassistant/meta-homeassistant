LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a5eb74eb0b84de9e63b66147166bc4b5"

inherit pypi setuptools3

SRC_URI = "https://files.pythonhosted.org/packages/source/g/gtts-token/gTTS-token-${PV}.tar.gz"

S = "${WORKDIR}/gTTS-token-${PV}"

SRC_URI[md5sum] = "2d21ca76976f9e803d3ec7fd6ca4f303"
SRC_URI[sha256sum] = "9d6819a85b813f235397ef931ad4b680f03d843c9b2a9e74dd95175a4bc012c5"

RDEPENDS_${PN} = "\
	${PYTHON_PN}-requests (>=2.22.0) \
"
