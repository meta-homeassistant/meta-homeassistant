SUMMARY = "Simple retry client for aiohttp"
DESCRIPTION = "Python client that retries failed aiohttp requests"
HOMEPAGE = "https://github.com/inyutin/aiohttp_retry"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d37fc449eb112dc6aace331d0e5f6a3e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/inyutin/aiohttp_retry.git;protocol=https;branch=master"

SRCREV = "39b23915023dde0e0298b822de3d23960a5024e6"

inherit ptest-python-pytest setuptools3

RDEPENDS:${PN} += "python3-aiohttp"
RDEPENDS:${PN}-ptest += "\
    python3-pytest-aiohttp \
    python3-pytest-asyncio \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
