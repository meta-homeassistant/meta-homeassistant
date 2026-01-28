SUMMARY = "Calculation library for CRCs and checksums"
HOMEPAGE = "https://github.com/MartinScharrer/crccheck"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=0dd1aefd20cb4bb72cc16c40552b922e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5384f437de610ade5c3d8689efc80ccd1267b8c452ade83411fd8500a1024f3e"
SRC_URI = "git://github.com/MartinScharrer/crccheck;protocol=https;tag=v${PV};branch=main"

inherit setuptools3 ptest-python-pytest
