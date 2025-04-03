SUMMARY = "Library to control Airzone Cloud devices"
HOMEPAGE = "https://github.com/Noltari/aioairzone-cloud"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a13f5c9773171eb2a6490ceb5f45ccd59a4c0caad263ee79829d806ca90621b8"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "aioairzone_cloud"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
RDEPENDS:${PN} = "python3-aiohttp"
