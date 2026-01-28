SUMMARY = "Unofficial python SDK for Brunt, this package allows you to control your Brunt devices from code."
HOMEPAGE = "https://github.com/eavanvalkenburg/brunt-api"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7409e384ce7c5a0c018906398c084d75"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "e704627dc7b9c0a50c67ae90f1d320b14f99f2b2fc9bf1ef0461b141dcf1bce9"

inherit pypi python_setuptools_build_meta ptest-python-pytest

DEPENDS += "python3-setuptools-scm-native"

RDEPENDS:${PN} = "\
    python3-aiohttp \
"

RDEPENDS:${PN}-ptest:append = "\
    python3-pytest-asyncio \
    python3-requests \
"

PYPI_PACKAGE = "brunt"
