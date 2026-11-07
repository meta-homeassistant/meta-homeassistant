SUMMARY = "Python interface for Danfoss Air HRV systems"
HOMEPAGE = "https://github.com/JonasPed/pydanfoss-air"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "9805b6cd3767a4b07884fdfed82e8d19a2e13b81bf2b2e7024c4edd545ceb7a2"

inherit pypi python_setuptools_build_meta

DEPENDS += "python3-wheel-native"
