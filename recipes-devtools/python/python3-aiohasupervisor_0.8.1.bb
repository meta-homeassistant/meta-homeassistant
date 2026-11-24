SUMMARY = "Asynchronous python client for Home Assistant Supervisor."
HOMEPAGE = "https://github.com/home-assistant-libs/python-supervisor-client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/home-assistant-libs/python-supervisor-client;protocol=https;tag=${PV};branch=main"
SRCREV = "aa4eec3403cb942b3acf1c87c41be1359bf02877"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.3.0) \
    python3-mashumaro (>=3.11) \
    python3-orjson (>=3.6.1) \
"

RDEPENDS:${PN}-ptest += "\
    python3-aiointercept \
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-pytest-timeout \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
    # pytest-asyncio >= 1.4 warns when the fixture loop scope is unset, and
    # filterwarnings = "error" turns that into a startup error. Set the
    # scope pytest-asyncio announces as its future default.
    sed -i '/^asyncio_mode = /a asyncio_default_fixture_loop_scope = "function"' \
        ${D}${PTEST_PATH}/pyproject.toml
}
