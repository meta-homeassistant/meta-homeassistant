DESCRIPTION = "Read metadata from Python packages"
HOMEPAGE = "https://pypi.org/project/importlib-metadata/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e88ae122f3925d8bde8319060f2ddb8e"

SRC_URI = "https://files.pythonhosted.org/packages/27/49/58d50a592d99a6bf58c4c1b02b203a48357a74e33922a9d021fda07d4ce3/importlib_metadata-0.19.tar.gz"
S = "${WORKDIR}/importlib_metadata-${PV}"

SRC_URI[md5sum] = "ab12a9fe47add2ccd746dad3a66d7504"
SRC_URI[sha256sum] = "23d3d873e008a513952355379d93cbcab874c58f4f034ff657c7a87422fa64e8"

DEPENDS += "\
    ${PYTHON_PN}-setuptools-scm-native \
"

RDEPENDS_${PN} += "\
    ${PYTHON_PN}-zipp \
    ${PYTHON_PN}-pathlib2 \
"
