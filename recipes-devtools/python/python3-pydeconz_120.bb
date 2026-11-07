SUMMARY = "Python library for communicating with deCONZ REST-API"
HOMEPAGE = "https://github.com/Kane610/deconz"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e4c00cdf90740d5e65a081a60c093ae4"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "python3-wheel-native"

SRC_URI += "\
    git://github.com/Kane610/deconz.git;branch=master;protocol=https;tag=v${PV} \
    file://0001-relax-build-req.patch"
SRC_URI[sha256sum] = "bb6cdcb1c92a5b30b809b7a2b538986ea81e70e3828918c4bcf0bb50e2ecb0e6"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.11.14) \
    python3-orjson (>=3.10.15) \
"

RDEPENDS:${PN}-ptest += "\
    python3-aioresponses \
    python3-pytest-aiohttp \
    python3-pytest-asyncio \
    python3-pytest-cov \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
