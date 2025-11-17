SUMMARY = "Python 2.7-3.5 clients for gpsd"
HOMEPAGE = "https://github.com/wadda/gps3"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${WHL_BP}.dist-info/METADATA;md5=802a66516ca62c5cc6eda4a2940c40d6"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi_wheel

WHL_PKG_URI = "20/c1/9548cb5388a85e31557d1f1f66e2ad0b269d8aeb982f34f72f83d9bdbaeb"
WHL_PYTHON_TAG = "py2.py3"

SRC_URI[x86_64.sha256sum] = "9c7ef9fa334ae6d4157fa63abe6df334d4f0878dbb628d10cb4c5f304eb22978"
SRC_URI[aarch64.sha256sum] = "9c7ef9fa334ae6d4157fa63abe6df334d4f0878dbb628d10cb4c5f304eb22978"
