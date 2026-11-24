SUMMARY = "Python client library for the OHF Matter Server BLE proxy protocol"
DESCRIPTION = "Python client library for the OHF Matter Server BLE proxy \
    WebSocket protocol."
HOMEPAGE = "https://github.com/matter-js/matterjs-server"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://pyproject.toml;beginline=23;endline=23;md5=2507bd5f0713f05419cd2f22fa06fe62"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "847f5c869526ae623f5be9f033403313e91ef593b94b1d41514a2eb4b94c9616"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-bleak \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-aiohttp \
    python3-pytest-asyncio \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
