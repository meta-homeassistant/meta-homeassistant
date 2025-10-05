SUMMARY = "Python wrapper for FutureNow IP relay/dimmer units"
HOMEPAGE = "http://github.com/juhaniemi/pyfnip"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=12;endline=12;md5=c3f07aaf829a0fa3e19b2ed383f777ad"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "6abc08b2ab23f9deac31ab4125cd5e12bf7936f83c63d95fa4eb413dc1caa260"

inherit pypi setuptools3

PYPI_PACKAGE = "pyfnip"
