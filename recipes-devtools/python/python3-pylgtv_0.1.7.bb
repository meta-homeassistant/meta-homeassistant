SUMMARY = "Library to control webOS based LG Tv devices"
HOMEPAGE = "https://github.com/TheRealLink/pylgtv"
SECTION = "devel/python"
LICENSE = "MIT"
#TODO: https://github.com/TheRealLink/pylgtv/pull/11
LIC_FILES_CHKSUM = "file://setup.cfg;md5=29f11c1f2512253649f5abd41eec7601"

inherit setuptools3 pypi

SRC_URI[md5sum] = "40f2f355c281f2564b62020f945425ed"
SRC_URI[sha256sum] = "be80882149b12b7db0c8232f097476a64ccb53c0eee6e0ed8a7fcd7e403f85cc"

RDEPENDS_${PN} = "${PYTHON_PN}-websockets ${PYTHON_PN}-asyncio"
