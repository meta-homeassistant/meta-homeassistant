SUMMARY = "Python API for interacting with luftdaten.info"
HOMEPAGE = "https://github.com/home-assistant-ecosystem/python-luftdaten"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b8bb8643d40e7ee8063674ef25c3b812"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3c476781f60c965bf7b2ea9fa7db3ece368cfbd25f710c049eaf5f735a9a4bdf"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "python3-httpx (>=0.23)"
