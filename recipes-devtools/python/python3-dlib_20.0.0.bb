SUMMARY = "A toolkit for making real world machine learning and data analysis applications"
HOMEPAGE = "https://pypi.org/project/dlib/"
LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=2c7a3fa82e66676005cd4ee2608fd7d2"

SRC_URI += "file://0001-Fix-compilation.patch"
SRC_URI[sha256sum] = "9ab6a6fe113cc36a20c3f611c57fa6a07f18d1169bd04efb85c32e21b23b7d2b"

DEPENDS = "\
    python3-pybind11 \
    python3-native \
"

inherit pypi cmake python_setuptools_build_meta

EXTRA_OECMAKE += "\
    -DPYTHON_EXECUTABLE=${STAGING_BINDIR_NATIVE}/python3 \
"

PYPI_PACKAGE = "dlib"

