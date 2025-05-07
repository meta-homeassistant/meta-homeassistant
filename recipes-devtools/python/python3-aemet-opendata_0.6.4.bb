SUMMARY = "AEMET OpenData Rest API library"
HOMEPAGE = "https://github.com/Noltari/AEMET-OpenData"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=60d644347832d2dd9534761f6919e2a6"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "0088fa57054fc54470befa1298eef008d0a5bda828691b90bbf6cff545490213"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "aemet_opendata"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-geopy\
"
