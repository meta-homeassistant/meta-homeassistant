SUMMARY = "Async version of apcaccess library implemented in python."
HOMEPAGE = "https://github.com/yuxincs/aioapcaccess"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d065570c3f29ddc11696c539cc461035"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "python3-setuptools-scm-native"

SRC_URI = "git://github.com/yuxincs/aioapcaccess.git;protocol=https;branch=main"
SRCREV = "a3f053ea68d05206a792dbc0f367c273dc9ddc38"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN}-ptest:append = "\
    python3-pytest-asyncio \
    python3-pytest-cov \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
