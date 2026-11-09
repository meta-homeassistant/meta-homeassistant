SUMMARY = "An implementation of the Debug Adapter Protocol for Python"
HOMEPAGE = "https://github.com/microsoft/debugpy/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7b6b095fe2a2e2b66cb08d295b605789"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "python3-wheel-native"

SRC_URI[sha256sum] = "e489c7268e1c7b41e13b438d9c533d2a7af73fb59bf8cd30fead8286c1c39c4e"

inherit pypi python_setuptools_build_meta
