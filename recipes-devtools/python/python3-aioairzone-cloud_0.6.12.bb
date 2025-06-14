SUMMARY = "Library to control Airzone Cloud devices"
HOMEPAGE = "https://github.com/Noltari/aioairzone-cloud"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f604dd6342d805cb4149646a302bbbb9f3344201e11eccd95e56bdb0e6b0d5d5"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "aioairzone_cloud"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
RDEPENDS:${PN} = "python3-aiohttp"
