SUMMARY = "A wrapper for the Blue Current websocket api"
HOMEPAGE = "https://github.com/bluecurrent/HomeAssistantAPI"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=90d2b1b857badb9893f587d4e016b2fa"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "679bc29fc37e3df0504e92b6595db44dade80b459bfcc7e394b4fb9a5853bdf2"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "bluecurrent_api"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-pytz (>=2023.4) \
    python3-websockets (>=15.0) \
"
