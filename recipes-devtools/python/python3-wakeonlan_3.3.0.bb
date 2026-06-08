SUMMARY = "A small python module for wake on lan."
HOMEPAGE = "https://github.com/remcohaszing/pywakeonlan"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=f8b3f077e531182116789a1d25297f55"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "80ec2163ecb3a091c6fa655e5e3106968ceaa4541ed90afa6391d1011fef71f2"

inherit pypi python_poetry_core
