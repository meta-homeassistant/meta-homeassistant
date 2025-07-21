SUMMARY = "Get data from the Azure DevOps API"
HOMEPAGE = "https://github.com/timmo001/aioazuredevops"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-add-missing-build-file-and-PEP517-compliant.patch"
SRC_URI[sha256sum] = "ae2be9f27222f62f9616e896a8cab60425fb08d312562f77140312a85d1d3bc7"

inherit pypi python_setuptools_build_meta ptest-python-pytest

DEPENDS += "python3-incremental-native"

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.9.0b0) \
    python3-incremental (>=22.10.0) \
"

PYPI_PACKAGE = "aioazuredevops"
