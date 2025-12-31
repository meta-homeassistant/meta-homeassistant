SUMMARY = "Asynchronous python client for Home Assistant Supervisor."
HOMEPAGE = "https://github.com/home-assistant-libs/python-supervisor-client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "24e268f58f37f9d8dafadba2ef9d860292ff622bc6e78b1ca4ef5e5095d1bbc8"
SRC_URI = "git://github.com/home-assistant-libs/python-supervisor-client;protocol=https;tag=${PV};branch=main"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.3.0) \
    python3-mashumaro (>=3.11) \
    python3-orjson (>=3.6.1) \
    python3-yarl (>=1.6.0) \
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
