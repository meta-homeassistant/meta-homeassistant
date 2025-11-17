SUMMARY = "Self-contained voice activity detector"
HOMEPAGE = "https://github.com/rhasspy/pymicro-vad"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-pybind11-native \
"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "b386ff00fad76e29fa145a8af472cde9e1275c2716ef5c350e7a143b8d97f507"

PYPI_PACKAGE = "pymicro_vad"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
