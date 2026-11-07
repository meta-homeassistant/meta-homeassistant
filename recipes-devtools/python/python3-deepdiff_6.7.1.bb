SUMMARY = "Deep Difference and Search of any Python object/data. Recreate objects by adding adding deltas to each other."
HOMEPAGE = "https://github.com/seperman/deepdiff"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e198d0e743566d10838655404b7363c0"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-repair-tests.patch"
SRC_URI[sha256sum] = "b367e6fa6caac1c9f500adc79ada1b5b1242c50d5f716a1a4362030197847d30"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PACKAGECONFIG[cli] = ",,,python3-click python3-pyyaml"
PACKAGECONFIG[optimize] = ",,,python3-orjson"

RDEPENDS:${PN} += "python3-ordered-set python3-statistics"

RDEPENDS:${PN}-ptest += " \
    python3-click \
    python3-dateutil \
    python3-jsonpickle \
    python3-numpy \
    python3-pydantic \
    python3-pyyaml \
    python3-tomli-w \
"

do_install_ptest:append() {
    install -m 0644 ${S}/conftest.py ${D}${PTEST_PATH}/conftest.py
}
