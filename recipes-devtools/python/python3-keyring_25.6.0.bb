SUMMARY = "Store and access your passwords safely."
HOMEPAGE = "https://github.com/jaraco/keyring"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=141643e11c48898150daa83802dbc65f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI:append = " \
    file://run-ptest \
    "
SRC_URI[sha256sum] = "0b39998aa941431eb3d9b0d4b2460bc773b9df6fed7621c2dfb291a7e0187a66"

inherit pypi python_setuptools_build_meta ptest

DEPENDS += "python3-setuptools-scm-native"

PYPI_PACKAGE = "keyring"
RDEPENDS:${PN} = "\
    python3-secretstorage \
    python3-jeepney \
    python3-importlib-metadata \
    python3-jaraco.classes \
    python3-jaraco.functools \
    python3-jaraco.context \
"

RDEPENDS:${PN}-ptest = "\
    python3-pytest \
    python3-unittest-automake-output \
"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
}
