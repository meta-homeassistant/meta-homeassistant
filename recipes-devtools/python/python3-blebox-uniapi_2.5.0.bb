SUMMARY = "Python API for accessing BleBox smart home devices"
HOMEPAGE = "https://github.com/blebox/blebox_uniapi"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ad92c4624dccd116fcc1816c7b9283ec"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-make-PEP-517-compatible.patch \
           file://0002-fix-compilation.patch \
           "
SRC_URI[sha256sum] = "967d003c81de4e8b7a143147f7e6872c2edccaed6ac6cc9c2719944d7b06526d"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.8.5) \
    python3-jmespath (>=1.0.0) \
"

PYPI_PACKAGE = "blebox_uniapi"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
