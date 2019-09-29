DESCRIPTION = "ECDSA cryptographic signature library"
HOMEPAGE = "https://github.com/warner/python-ecdsa"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI[md5sum] = "0ce51d17c0751e5232be4eafd69b7f13"
SRC_URI[sha256sum] = "5c034ffa23413ac923541ceb3ac14ec15a0d2530690413bff58c12b80e56d884"

inherit setuptools3 pypi

DEPENDS += " \
    ${PYTHON_PN}-pbr \
"

# RDEPENDS_default:
RDEPENDS_${PN} += " \
    ${PYTHON_PN}-pbr \
"
