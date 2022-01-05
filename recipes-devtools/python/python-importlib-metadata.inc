DESCRIPTION = "Read metadata from Python packages"
HOMEPAGE = "https://pypi.org/project/importlib-metadata/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e88ae122f3925d8bde8319060f2ddb8e"

SRC_URI = "https://files.pythonhosted.org/packages/0d/e4/638f3bde506b86f62235c595073066e7b8472fc9ee2b8c6491347f31d726/importlib_metadata-1.5.0.tar.gz"
S = "${WORKDIR}/importlib_metadata-${PV}"

SRC_URI[md5sum] = "1ec9bfc71c20e8618eac4a267aee2ad1"
SRC_URI[sha256sum] = "06f5b3a99029c7134207dd882428a66992a9de2bef7c2b699b5641f9886c3302"

DEPENDS += "\
    ${PYTHON_PN}-setuptools-scm-native \
"

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-zipp \
    ${PYTHON_PN}-pathlib2 \
"
