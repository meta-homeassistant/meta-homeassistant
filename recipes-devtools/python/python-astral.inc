SUMMARY = "Calculations for the position of the sun and moon"
HOMEPAGE = "https://github.com/sffjunkie/astral"
LICENSE = "Apache-2.0"
#TODO: https://github.com/sffjunkie/astral/pull/17
LIC_FILES_CHKSUM = "file://setup.py;md5=9ccb52dc253a352ca5c2d03e515e1590"

inherit pypi

SRC_URI[md5sum] = "dd4bfac94c2dd60bd5e4e61635c113bf"
SRC_URI[sha256sum] = "874b397ddbf0a4c1d8d644b21c2481e8a96b61343f820ad52d8a322d61a15083"

# setup.py of astral requires it
DEPENDS += "${PYTHON_PN}-pytz-native"
