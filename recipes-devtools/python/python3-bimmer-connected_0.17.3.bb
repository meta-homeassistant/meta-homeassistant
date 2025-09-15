SUMMARY = "Library to read data from the BMW Connected Drive portal"
HOMEPAGE = "https://github.com/bimmerconnected/bimmer_connected"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-make-PEP-517-compatible.patch"
SRC_URI[sha256sum] = "bd86f6cd4d50fc601248745c7f919163b9d95d475747b40c1c808e133da6072d"

inherit pypi python_setuptools_build_meta ptest-python-pytest

DEPENDS += "python3-pbr-native"

RDEPENDS:${PN} += "\
    python3-pillow \
    python3-httpx \
    python3-pycryptodome (>=3.4) \
    python3-pyjwt (>=2.1.0)\
"

PYPI_PACKAGE = "bimmer_connected"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
