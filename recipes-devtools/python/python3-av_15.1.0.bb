SUMMARY = "Pythonic bindings for FFmpeg's libraries."
HOMEPAGE = "https://github.com/PyAV-Org/PyAV"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=a9c4cea4308c4521674ecd7c3255d8af"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    ffmpeg \
    python3-native \
"

SRC_URI = "git://github.com/PyAV-Org/PyAV.git;protocol=https;branch=main"
SRC_URI[sha256sum] = "05eea82b1c92619884abe4f0ed1e98f83b21c3fdf5b2e8aa924c835cfec83293"
SRCREV = "e3f2efd85e8c36c1f7b1a14660e05b5c7909a6e6"

inherit setuptools3 pkgconfig cython ptest-python-pytest
