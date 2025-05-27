SUMMARY = "Sniff out which async library your code is running under"
HOMEPAGE = "https://github.com/python-trio/sniffio"
LICENSE = "MIT | Apache-2.0"
LIC_FILES_CHKSUM = "\
    file://LICENSE.MIT;md5=e62ba5042d5983462ad229f5aec1576c \
    file://LICENSE.APACHE2;md5=3b83ef96387f14655fc854ddc3c6bd57 \
"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f4324edc670a0f49750a81b895f35c3adb843cca46f0530f79fc1babb23789dc"

inherit pypi setuptools3
