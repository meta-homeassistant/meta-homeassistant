SUMMARY = "Calculations for the position of the sun and moon"
HOMEPAGE = "https://github.com/sffjunkie/astral"
LICENSE = "Apache-2.0"

inherit setuptools3 pypi

LIC_FILES_CHKSUM = "file://LICENSE;md5=2a944942e1496af1886903d274dedb13"

SRC_URI[md5sum] = "4b7f144a2d0f743295ebe97de08406de"
SRC_URI[sha256sum] = "e41d9967d5c48be421346552f0f4dedad43ff39a83574f5ff2ad32b6627b6fbe"

RDEPENDS:{PN} = "\
    ${PYTHON_PN}-pytz \
"