SUMMARY = "Python API for controlling Broadlink devices"
HOMEPAGE = "http://github.com/mjg59/python-broadlink"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=41e038530f86b1b37b29ec7c9c4a7218"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "203e58a548e2a3af310a1b3a6614d0056f7de64a9b9b0b0049124a4356b93365"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-cryptography (>=3.2)"

PYPI_PACKAGE = "broadlink"
