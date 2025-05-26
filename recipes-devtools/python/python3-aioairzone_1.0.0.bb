SUMMARY = "Library to control Airzone devices"
HOMEPAGE = "https://github.com/Noltari/aioairzone"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "6eafb958e2978349bb2d41b3ced9e5edc2646ef0adc4fd83586a3562606d548d"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "aioairzone"
RDEPENDS:${PN} = "python3-aiohttp"
