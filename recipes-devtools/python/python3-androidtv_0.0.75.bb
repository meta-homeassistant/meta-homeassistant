SUMMARY = "Communicate with an Android TV or Fire TV device via ADB over a network."
HOMEPAGE = "https://github.com/JeffLIrion/python-androidtv/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0f9ec581233111411af2ae6ec4e3a624"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f761a5d82b252e20e20aca3f07a3109698bab649b97d8247fb18404921e1d367"

inherit pypi setuptools3 ptest-python-pytest

PACKAGECONFIG ?= "async"
PACKAGECONFIG[async] = ",,,python3-aiofiles python3-async-timeout"
PACKAGECONFIG[usb] = ",,,python3-adb-shell"

RDEPENDS:${PN} += "\
    python3-adb-shell \
    python3-pure-python-adb \
"

PYPI_PACKAGE = "androidtv"
