SUMMARY = "Library to control Airzone devices"
HOMEPAGE = "https://github.com/Noltari/aioairzone"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "248b092cc098f9305f8576babed7d5608de38103bd9b6ff594ae95b14520b669"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "aioairzone"
RDEPENDS:${PN} = "python3-aiohttp"
