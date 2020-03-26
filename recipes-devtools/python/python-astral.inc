SUMMARY = "Calculations for the position of the sun and moon"
HOMEPAGE = "https://github.com/sffjunkie/astral"
LICENSE = "Apache-2.0"
#TODO: https://github.com/sffjunkie/astral/pull/17
LIC_FILES_CHKSUM = "file://setup.py;md5=22fb02a95616804a9619452bbd1cb749"

inherit pypi

SRC_URI[md5sum] = "24179a8ca5b2edbd9cc49244cc294d9b"
SRC_URI[sha256sum] = "d2a67243c4503131c856cafb1b1276de52a86e5b8a1d507b7e08bee51cb67bf1"

# setup.py of astral requires it
DEPENDS += "${PYTHON_PN}-pytz-native"

RDEPENDS_${PN} +="\
    ${PYTHON_PN}-pytz \
    ${PYTHON_PN}-requests \
"
