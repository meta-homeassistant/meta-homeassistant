SUMMARY = "An async implementation of the EnOcean Serial Protocol Version 3."
DESCRIPTION = "Asynchronous implementation of the EnOcean Serial Protocol version \
    3 (ESP3) for EnOcean USB and serial gateways."
HOMEPAGE = "https://github.com/henningkerstan/enocean-async"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

# The PyPI sdist ships no tests. The v0.4.2 tag is only on the
# fix-a5-02-range branch, not on main.
SRC_URI = "git://github.com/henningkerstan/enocean-async.git;protocol=https;tag=v${PV};nobranch=1"
SRCREV = "b86127607222bc07036f45dc8c515174d653a6f2"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-pyserial-asyncio-fast \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
    # tests/test_eep.py of the 0.4.2 sdist imports EnOceanManufacturers, which
    # that release has renamed to eep.manufacturer.Manufacturer. Later
    # releases fixed the test; Home Assistant 2026.11 pins 0.4.2.
    sed -i '/^\[tool\.pytest\.ini_options\]/a addopts = "--ignore=tests/test_eep.py"' ${D}${PTEST_PATH}/pyproject.toml
}
