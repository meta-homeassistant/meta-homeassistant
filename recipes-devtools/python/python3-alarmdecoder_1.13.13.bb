SUMMARY = "Python interface for the AlarmDecoder (AD2) family of alarm devices which includes the AD2USB, AD2SERIAL and AD2PI."
HOMEPAGE = "http://github.com/nutechsoftware/alarmdecoder"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d6a8cd140d803ec3750c24df6f845ba8"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += " \
    file://0001-Update-test-functions.patch \
    file://0001-Make-PEP517-compliant.patch \
    file://run-ptest \
"
SRC_URI[sha256sum] = "393664a8bbe6e6a0fc809e64eddb0b30a9c9f757bbf6e4fe68fd7d91342d1187"

inherit pypi python_setuptools_build_meta ptest-python-pytest

DEPENDS += "python3-setuptools-scm-native"

RDEPENDS:${PN} += "python3-pyserial (>=2.7)"

PYPI_PACKAGE = "alarmdecoder"

PTEST_PYTEST_DIR = "test"

RDEPENDS:${PN}-ptest += "\
    python3-mock \
"
