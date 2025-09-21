SUMMARY = "Library to control Airzone Cloud devices"
HOMEPAGE = "https://github.com/Noltari/aioairzone-cloud"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f64ff778cd06cad3e64b09aa4d474766bf1eba22dafb86cd2e2cc2d1d0435102"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "aioairzone_cloud"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
RDEPENDS:${PN} = "python3-aiohttp"
