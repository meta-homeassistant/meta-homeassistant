SUMMARY = "A library that handling with ffmpeg for home-assistant"
HOMEPAGE = "https://github.com/pvizeli/ha-ffmpeg"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3f29f6595321db2f1333b32f61866572"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "80e4a77b3eda73df456ec9cc3295a898ed7cbb8cd2d59798f10e8c10a8e6c401"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-async-timeout \
    ffmpeg \
"

PYPI_PACKAGE = "ha_ffmpeg"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
