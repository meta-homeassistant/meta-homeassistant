SUMMARY = "Python Library to access AVM Fritz!Box homeautomation"
HOMEPAGE = "https://github.com/hthiery/python-fritzhome"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=01351c51c0264f1a06fee66797afb35a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/hthiery/python-fritzhome.git;protocol=https;branch=master"
SRCREV = "17befd6640ce2f8e9a9ede54ed2a57c6dd427aeb"

inherit setuptools3 ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-cryptography \
    python3-requests \
"
