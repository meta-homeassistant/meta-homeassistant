SUMMARY = "Asyncio implementation of the Spinel protocol for OpenThread RCPs"
DESCRIPTION = "An asyncio implementation of the Spinel protocol used to \
    communicate with OpenThread RCPs over a serial connection."
HOMEPAGE = "https://pypi.org/project/aiospinel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "152d737c4d47ffed1195a832045b2c99391dfc04a3ce1e8120b48ad616828194"

inherit pypi python_setuptools_build_meta ptest-python-pytest

DEPENDS += "python3-setuptools-scm-native"

RDEPENDS:${PN} += "\
    python3-typing-extensions \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
    python3-pytest-timeout \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
