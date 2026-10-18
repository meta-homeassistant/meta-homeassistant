SUMMARY = "Deepmerge: merging nested data structures"
HOMEPAGE = "https://github.com/toumorokoshi/deepmerge"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5461efe2d19ce359c7d72d7be3c05e1c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI:append = " file://0001-remove-setuptools_scm-from-dependency.patch"
SRC_URI[sha256sum] = "4c27a0db5de285e1a7ceac7dbc1531deaa556b627dea4900c8244581ecdfea2d"

DEPENDS += "python3-wheel-native"

inherit pypi python_setuptools_build_meta
