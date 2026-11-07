SUMMARY = "Python One Time Password Library"
HOMEPAGE = "https://github.com/pyotp/pyotp"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f4889ab24aecac0a410d83c0323f9daf"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d01e9703443616b03c57c700b5cbffd56a1f929c1b0f8f03131bc78c1fca9d3f"

inherit pypi python_hatchling

DEPENDS += "python3-hatch-vcs-native"
