SUMMARY = "Read and control a Flexit air handling unit with a CI66 Modbus adapter."
DESCRIPTION = "Python library to read and control Flexit air handling units \
    through the CI66 Modbus adapter."
HOMEPAGE = "https://github.com/troelde/flexit-modbus"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4cd44ad932f9954df0a7c5b9b468f432"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d86fb6584f671e1adb219c282e7a01939408b594761db39479cd6f0bf18deb0a"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-modbus-connection \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
    # tests/test_query_cli.py loads script/query.py
    install -d ${D}${PTEST_PATH}/script
    install -m 0644 ${S}/script/*.py ${D}${PTEST_PATH}/script/
}
