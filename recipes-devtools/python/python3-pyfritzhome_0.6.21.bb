SUMMARY = "Python Library to access AVM Fritz!Box homeautomation"
HOMEPAGE = "https://github.com/hthiery/python-fritzhome"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=01351c51c0264f1a06fee66797afb35a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/hthiery/python-fritzhome.git;protocol=https;branch=master;tag=${PV}"
SRCREV = "825a7a24ddb0ea6a723e9636dc6adc196bdaabec"

inherit setuptools3 ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-cryptography \
    python3-requests \
"
