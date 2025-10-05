SUMMARY = "A Python3, async-friendly library for Flo by Moen Smart Water Detectors"
HOMEPAGE = "https://github.com/bachya/aioflo"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3420ba8cd407f2955cd5b2818b03b452"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-adjust-build-req.patch"
SRC_URI[sha256sum] = "fc4e8a3749c59661acda2ee56397f8f8991492cbcdeaa773e66416d376f23d0f"

inherit pypi python_poetry_core

RDEPENDS:${${PN} = "\
    python3-aiohttp (>=3.7.4) \
"

PYPI_PACKAGE = "aioflo"
