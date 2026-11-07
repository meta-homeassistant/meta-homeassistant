SUMMARY = "Library for the Modbus TCP (SunSpec) interface of Fronius inverters"
DESCRIPTION = "Async Python library for the Modbus TCP (SunSpec) interface of \
    Fronius inverters, built on modbus-connection."
HOMEPAGE = "https://github.com/farmio/fronius-modbus"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

# The PyPI sdist does not contain the test suite.
SRC_URI = "git://github.com/farmio/fronius-modbus.git;protocol=https;branch=main;tag=${PV}"
SRCREV = "ba48b916bd550a0612e8f4b8e647c23c94427c66"

inherit python_hatchling ptest-python-pytest

DEPENDS += "python3-hatch-vcs-native"

RDEPENDS:${PN} += "\
    python3-modbus-connection \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
