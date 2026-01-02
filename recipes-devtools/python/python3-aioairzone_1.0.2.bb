SUMMARY = "Library to control Airzone devices"
HOMEPAGE = "https://github.com/Noltari/aioairzone"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "fd6d605ef282467eac48a045b4d1f91c968eed75fb2487294da725f8f1562194"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "aioairzone"
RDEPENDS:${PN} = "python3-aiohttp"
