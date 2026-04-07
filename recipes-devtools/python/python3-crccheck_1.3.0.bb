SUMMARY = "Calculation library for CRCs and checksums"
HOMEPAGE = "https://github.com/MartinScharrer/crccheck"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=0dd1aefd20cb4bb72cc16c40552b922e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/MartinScharrer/crccheck;protocol=https;tag=v${PV};branch=main"
SRCREV = "92da616bb12c7fbefbe239bd013fc03c3bf8c4c4"

inherit setuptools3 ptest-python-pytest
