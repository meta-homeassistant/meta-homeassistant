SUMMARY = "Asynchronous python client for Home Assistant Supervisor."
HOMEPAGE = "https://github.com/home-assistant-libs/python-supervisor-client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/home-assistant-libs/python-supervisor-client;protocol=https;tag=${PV};branch=main"
SRCREV = "2dd74d0d573dad26938f6d4138fb26cb2db06cb0"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.3.0) \
    python3-mashumaro (>=3.11) \
    python3-orjson (>=3.6.1) \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-aiohttp \
    python3-pytest-timeout \
    python3-aioresponses \
    python3-pytest-asyncio \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
