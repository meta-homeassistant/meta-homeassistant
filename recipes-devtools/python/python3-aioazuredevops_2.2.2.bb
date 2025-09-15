SUMMARY = "Get data from the Azure DevOps API"
HOMEPAGE = "https://github.com/timmo001/aioazuredevops"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-add-missing-build-file-and-PEP517-compliant.patch"
SRC_URI[sha256sum] = "b2b8f37e62135b252c55bacad1e8dd92b83a0fb67ed35416cebbbbda4c6bd9c9"

inherit pypi python_setuptools_build_meta ptest-python-pytest

DEPENDS += "python3-incremental-native"

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.9.0b0) \
    python3-incremental (>=22.10.0) \
"

PYPI_PACKAGE = "aioazuredevops"
