SUMMARY = "Python API for controlling Decora dimmer switches"
HOMEPAGE = "http://github.com/mjg59/python-decora"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=13;endline=13;md5=c3f07aaf829a0fa3e19b2ed383f777ad"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "921194aaa0e58c55f3d743174723808ec4c18756bf83637de3efa8293fd6a558"

inherit pypi setuptools3

RDEPENDS:${PN} += "bluepy"

PYPI_PACKAGE = "decora"
