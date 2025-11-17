SUMMARY = "A package to talk to growatt server"
HOMEPAGE = "https://github.com/indykoning/PyPi_GrowattServer"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=10b415205d894eaeb7c3d08791aa219a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3e0286e4f5dd9a5e9d361acce170d1160f30bbf9c244ecefc81c89cb43c742ba"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-requests"

PYPI_PACKAGE = "growattServer"
