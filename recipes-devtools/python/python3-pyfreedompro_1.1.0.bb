SUMMARY = "Freedompro API"
HOMEPAGE = "https://github.com/stefano055415/pyfreedompro"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=23f9ad5cad3d8cc0336e2a5d8a87e1fa"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "92812070a0c74761fa0c8cac98ddbe0bca781c8de80e2b08dbd04492e831c172"

DEPENDS = "\
    python3-aiohttp-native \
    python3-asyncio-deprecated-native \
"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "pyfreedompro"
