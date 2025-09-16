SUMMARY = "Dynalite panel for Home Assistant"
HOMEPAGE = "https://github.com/ziv1234/dynalitepanel"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-relax-build-req.patch"
SRC_URI[sha256sum] = "9bb9d0cdbc517b6a9751600c79094366d73d174d43b1b4f317f908d1c8b74c51"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "dynalite-panel"
