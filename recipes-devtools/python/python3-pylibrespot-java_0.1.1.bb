SUMMARY = "Python Interface for librespot-java"
HOMEPAGE = "http://github.com/uvjustin/pylibrespot-java/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=04b41c2657ef501f8a71220d77bcb9c2"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "de2de1e69d9a0f4616de9afde8d97d17068491a2d1be40ea72e4250efa3f0dd0"

DEPENDS = "python3-aiohttp-native"

inherit pypi setuptools3


