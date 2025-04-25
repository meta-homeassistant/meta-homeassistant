SUMMARY = "Noise suppression and automatic gain with speex"
HOMEPAGE = "https://github.com/rhasspy/pyspeex-noise"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=ba62b0459ce9816c2c8c3f06154aa726"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "56a888ca2ef7fdea2316aa7fad3636d2fcf5f4450f3a0db58caa7c10a614b254"

inherit pypi python_setuptools_build_meta

DEPENDS += "\
    python3-pybind11-native \
"

PYPI_PACKAGE = "pyspeex_noise"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
