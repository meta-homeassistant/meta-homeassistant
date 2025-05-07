SUMMARY = "AlarmDecoder extended"
HOMEPAGE = "https://github.com/ajschmidt8/adext"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=31c8623bc439370f4fd7f41e531e161f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "ceff4bea010afc0dc41bb002c04fd46693ead4759a92fdec767b706093148663"

inherit pypi setuptools3 ptest-python-pytest

DEPENDS += "python3-setuptools-scm-native"

RDEPENDS:${PN} += "python3-alarmdecoder"

PYPI_PACKAGE = "adext"
