SUMMARY = "A tool for generating OIDC identities"
HOMEPAGE = "https://pypi.org/project/id/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "292cb8a49eacbbdbce97244f47a97b4c62540169c976552e497fd57df0734c1d"

inherit pypi python_flit_core

PYPI_PACKAGE = "id"
RDEPENDS:${PN} = "\
    python3-pydantic \
    python3-requests \
"

BBCLASSEXTEND = "native nativesdk"
