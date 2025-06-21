SUMMARY = "Self-contained voice activity detector"
HOMEPAGE = "https://github.com/rhasspy/pymicro-vad"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-pybind11-native \
"

SRC_URI = "git://github.com/rhasspy/pymicro-vad.git;protocol=https;branch=master"
SRC_URI[sha256sum] = "60e0508b338b694c7ad71c633c0da6fcd2678a88abb8e948b80fa68934965111"
SRCREV = "c3e17ff6bd56efbcddfdab06a83ba236b7b04643"

inherit python_setuptools_build_meta ptest-python-pytest
