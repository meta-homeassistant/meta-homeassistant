SUMMARY = "Python interface for the AlarmDecoder (AD2) family of alarm devices which includes the AD2USB, AD2SERIAL and AD2PI."
HOMEPAGE = "http://github.com/nutechsoftware/alarmdecoder"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d6a8cd140d803ec3750c24df6f845ba8"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "python3-setuptools-scm-native"

SRC_URI += "\
    file://0001-Update-test-functions.patch \
    file://run-ptest \
"
SRC_URI[sha256sum] = "b0713c75f694650af5007bf78fad5e1fc4c344d60e842e6941b020db0b52933e"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "python3-pyserial (>=2.7)"

PTEST_PYTEST_DIR = "test"

RDEPENDS:${PN}-ptest += "\
    python3-mock \
"
