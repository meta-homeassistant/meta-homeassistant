SUMMARY = "Calculates a token to run the Google Translate text to speech"
HOMEPAGE = "https://github.com/boudewijn26/gTTS-token"
LICENSE = "MIT"
#TODO: Use correct file once is fixed: https://github.com/Boudewijn26/gTTS-token/issues/5
#LIC_FILES_CHKSUM = "file://COPYING;md5=d7dba1721bc8ce05d421f7279cb87971"
LIC_FILES_CHKSUM = "file://setup.cfg;md5=15a8414e20874b802435250a336e2907"

PYPI_PACKAGE = "gTTS-token"
PYPI_PACKAGE_EXT = "zip"
inherit pypi

SRC_URI[md5sum] = "39f56680d81c3d553ccc663f013a48f8"
SRC_URI[sha256sum] = "74badf3ba37773d8ba4a462a09b64de76a0ebd4015d667a6fdb041c2219283ef"

RDEPENDS_${PN} = "${PYTHON_PN}-requests"
