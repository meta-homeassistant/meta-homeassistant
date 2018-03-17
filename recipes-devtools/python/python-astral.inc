SUMMARY = "Calculations for the position of the sun and moon"
HOMEPAGE = "https://github.com/sffjunkie/astral"
LICENSE = "Apache-2.0"
#TODO: https://github.com/sffjunkie/astral/pull/17
LIC_FILES_CHKSUM = "file://setup.py;md5=48ee914e7a41d510df6b8dce45fb1261"

inherit pypi

SRC_URI[md5sum] = "b752fc63b97bdff8e763ce1eb3aa6bd7"
SRC_URI[sha256sum] = "527628fbfe90c1596c3950ff84ebd07ecc10c8fb1044c903a0519b5057700cb6"

# setup.py of astral requires it
DEPENDS += "${PYTHON_PN}-pytz-native"
