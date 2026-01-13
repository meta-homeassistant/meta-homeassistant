SUMMARY = "The new features in unittest backported to Python 2.4+."
HOMEPAGE = "http://pypi.python.org/pypi/unittest2"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://setup.py;beginline=39;endline=39;md5=b10717d05a254eb69af524918ee907cd"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "22882a0e418c284e1f718a822b3b022944d53d2d908e1690b319a9d3eb2c0579"

inherit pypi setuptools3

# Provide build-time packages so setuptools won't try to fetch them with pip
DEPENDS += "python3-six-native python3-traceback2-native python3-argparse-native"
