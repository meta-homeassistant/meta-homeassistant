SUMMARY = "This is a python class to use nmap and access scan results from python3"
HOMEPAGE = "https://github.com/home-assistant-libs/python-nmap"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://gpl-3.0.txt;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "4360f7fac5d4d74b1e1b55bece62c59078e6a94a5516307f46295faacfd22cbf"

inherit pypi setuptools3

PYPI_PACKAGE = "netmap"
