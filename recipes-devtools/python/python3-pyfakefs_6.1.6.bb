SUMMARY = "Implements a fake file system that mocks the Python file system modules."
HOMEPAGE = "https://github.com/pytest-dev/pyfakefs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=34400b68072d710fecd0a2940a0d1658"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "dcdfc09b13f3fd464142e20ef6154639bd26fb0890572c5dd869339a083e2903"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "pyfakefs"

RDEPENDS:${PN} = "\
    python3-pandas (>=2.3.3) \
    python3-xlrd (>=2.0.2) \
    python3-openpyxl (>=3.1.5) \
"
