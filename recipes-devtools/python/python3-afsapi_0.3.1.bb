SUMMARY = "Asynchronous Implementation of the Frontier Silicon API"
HOMEPAGE = "https://github.com/zhelev/python-afsapi.git"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-remove-broken-nonfunctional-requirement.patch"
SRC_URI[sha256sum] = "10632841c2b5c1efb3a5d96c33471f75a4ad15c0221c9cac940fd6c7a1d13b42"

DEPENDS += "python3-setuptools-scm-native"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.3.2) \
    python3-lxml (>=3.6.0) \
"

PYPI_PACKAGE = "afsapi"
