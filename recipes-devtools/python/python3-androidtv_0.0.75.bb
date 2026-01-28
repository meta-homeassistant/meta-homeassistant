SUMMARY = "Communicate with an Android TV or Fire TV device via ADB over a network."
HOMEPAGE = "https://github.com/JeffLIrion/python-androidtv/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0f9ec581233111411af2ae6ec4e3a624"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "\
    git://github.com/JeffLIrion/python-androidtv;protocol=https;tag=v${PV};branch=master \
    file://run-ptest \
"

inherit setuptools3 ptest-python-pytest

PACKAGECONFIG ?= "async usb"
PACKAGECONFIG[async] = ",,,python3-aiofiles python3-async-timeout"
PACKAGECONFIG[usb] = ",,,python3-adb-shell"

RDEPENDS:${PN} += "\
    python3-adb-shell \
    python3-pure-python-adb \
    git \
"
