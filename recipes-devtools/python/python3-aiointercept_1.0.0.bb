SUMMARY = "Aiohttp mock library that routes requests through a real test server"
DESCRIPTION = "A lightweight aiohttp mocking library that routes requests through a real test server and provides a pytest plugin."
HOMEPAGE = "https://github.com/Polandia94/aiointercept"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=040993e960204718c5e0152b08262a92"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "99c52ba2d6c282f1e0cbeba2225279eca581cf24b6a3c893929bacf8774e8f70"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.13.3) \
    python3-multidict (>=6.0) \
    python3-yarl (>=1.23.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-ddt \
    python3-httpx \
    python3-pytest-asyncio \
    python3-requests \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
