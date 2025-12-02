SUMMARY = "Library for handling the Android IP Webcam app"
HOMEPAGE = "https://github.com/home-assistant-libs/pydroid-ipcam"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "88ffbd6e02e3fcd9416d30fae10d8415609bc6cdc7309daf8d23d0751e908675"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp"

PYPI_PACKAGE = "pydroid_ipcam"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
