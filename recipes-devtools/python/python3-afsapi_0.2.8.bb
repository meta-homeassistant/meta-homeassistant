SUMMARY = "Asynchronous Implementation of the Frontier Silicon API"
HOMEPAGE = "https://github.com/zhelev/python-afsapi.git"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-remove-setup-requirement.patch"
SRC_URI[sha256sum] = "e5366628cf606f1cd484f0d811e07008e00156d84e01a594a2a4270bb727c5c4"

DEPENDS += "python3-setuptools-scm-git-archive-native python3-setuptools-scm-native"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.3.2) \
    python3-lxml (>=3.6.0) \
"

PYPI_PACKAGE = "afsapi"
