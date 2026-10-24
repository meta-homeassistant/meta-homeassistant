SUMMARY = "A package to talk to growatt server"
HOMEPAGE = "https://github.com/indykoning/PyPi_GrowattServer"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=10b415205d894eaeb7c3d08791aa219a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a8fcf4867de4d8f609c850225442e76c43060592c60acc904fea72a69fa1a268"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-requests"
