SUMMARY = "Library to control webOS based LG Tv devices"
HOMEPAGE = "https://github.com/TheRealLink/pylgtv"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d4ae7def6b740abc020a2700493fef4e"

inherit setuptools3

SRCREV = "babf7b65c419ce4533b33d7e2aced7bc1abe7458"
SRC_URI = "git://github.com/TheRealLink/pylgtv.git;protocol=https"
S = "${WORKDIR}/git"

RDEPENDS_${PN} = "${PYTHON_PN}-websockets"
