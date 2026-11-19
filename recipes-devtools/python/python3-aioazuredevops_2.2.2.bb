SUMMARY = "Get data from the Azure DevOps API"
HOMEPAGE = "https://github.com/timmo001/aioazuredevops"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "python3-incremental-native"

SRC_URI += "\
    git://github.com/timmo001/aioazuredevops;protocol=https;tag=${PV};branch=master \
"
SRCREV = "27879a1a8e1f473305ec4986117ffc0319562c64"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.12.15) \
"

RDEPENDS:${PN}-ptest:append = " \
    python3-aioresponses \
    python3-pytest-aiohttp \
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-pytest-socket \
    python3-pytest-sugar \
    python3-pytest-timeout \
    python3-syrupy \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
