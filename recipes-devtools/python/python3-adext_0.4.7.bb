SUMMARY = "AlarmDecoder extended"
HOMEPAGE = "https://github.com/ajschmidt8/adext"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=31c8623bc439370f4fd7f41e531e161f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3a337d61f5d05dc758ee71b903369012e777319bb347287213c07d3829b2169b"

inherit pypi setuptools3 ptest-python-pytest

DEPENDS += "python3-setuptools-scm-native"

RDEPENDS:${PN} += "python3-alarmdecoder"

PYPI_PACKAGE = "adext"
