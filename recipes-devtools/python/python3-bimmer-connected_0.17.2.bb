SUMMARY = "Library to read data from the BMW Connected Drive portal"
HOMEPAGE = "https://github.com/bimmerconnected/bimmer_connected"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b1fa68caee58699ab9908d03d20cd37a97d1ac225565b839ec5bca9d79cfc7e3"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-pillow \
    python3-httpx \
    python3-pycryptodome (>=3.4) \
    python3-pyjwt (>=2.1.0)\
"

PYPI_PACKAGE = "bimmer_connected"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
