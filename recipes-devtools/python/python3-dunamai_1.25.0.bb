SUMMARY = "Dynamic version generation"
HOMEPAGE = "https://github.com/mtkennerly/dunamai"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=059eed55dbfd3fea022510ea62c95dc1"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a7f8360ea286d3dbaf0b6a1473f9253280ac93d619836ad4514facb70c0719d1"

inherit pypi python_poetry_core

PYPI_PACKAGE = "dunamai"
RDEPENDS:${PN} = "python3-packaging"

BBCLASSEXTEND = "native nativesdk"
