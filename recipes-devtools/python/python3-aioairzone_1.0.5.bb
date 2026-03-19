SUMMARY = "Library to control Airzone devices"
HOMEPAGE = "https://github.com/Noltari/aioairzone"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "01bb44e8aab9ad09f13e1e0af5cb4bc8f6a8ff9c27a11e83e5260a32c62f0f27"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "aioairzone"
RDEPENDS:${PN} = "python3-aiohttp"
