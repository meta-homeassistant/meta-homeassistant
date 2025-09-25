SUMMARY = "An API wrapper for Epic Games Store written in Python"
HOMEPAGE = "https://github.com/SD4RK/epicstore_api"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=eff633e027523d33f3a907f88c85677b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

PYPI_SRC_URI = "git://github.com/SD4RK/epicstore_api;protocol=https;branch=master"
SRC_URI[sha256sum] = "471daeb96f6282e401fac877bc8d8ce705574604ba1520e6a0292e202e1baa44"
SRCREV = "d7469f7c99508c06b3867fecbcf291ebf86c4c72"

inherit pypi python_setuptools_build_meta

S = "${UNPACKDIR}/python3-epicstore-api-${PV}"

RDEPENDS:${PN} += "\
    python3-cloudscraper \
"
