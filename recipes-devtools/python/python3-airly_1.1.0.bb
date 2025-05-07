SUMMARY = "Python wrapper for getting air quality data from Airly sensors."
HOMEPAGE = "https://github.com/ak-ambi/python-airly"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c4e290cf6e181b44594ed0bfc66adbd6c8bda7d6b89ac7fac1f1bd15cdb77570"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "airly"
