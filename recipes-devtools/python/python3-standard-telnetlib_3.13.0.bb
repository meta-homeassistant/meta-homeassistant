SUMMARY = "Standard library telnetlib redistribution. "dead battery"."
HOMEPAGE = "https://github.com/youknowone/python-deadlib"
LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4e3cd541391435e0a82da0f9f489e85f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "243333696bf1659a558eb999c23add82c41ffc2f2d04a56fae13b61b536fb173"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "standard_telnetlib"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

BBCLASSEXTEND = "native nativesdk"
