SUMMARY = "Deprecated backport of asyncio; use the stdlib package instead"
HOMEPAGE = "https://docs.python.org/3/library/asyncio.html"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=8f7bb094c7232b058c7e9f2e431f389c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "570cd9e50db83bc1629152d4d0b7558d6451bb1bfd5dfc2e935d96fc2f40329b"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "asyncio"

BBCLASSEXTEND = "native nativesdk"
