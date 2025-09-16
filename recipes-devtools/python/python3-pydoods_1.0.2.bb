SUMMARY = "A Python wrapper for the DOODS image detection service"
HOMEPAGE = "https://github.com/snowzach/pydoods"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=31;endline=31;md5=c3f07aaf829a0fa3e19b2ed383f777ad"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7dd84bdf48269b996fde26c38dc93b90fe804c7c44511b858335f918a46337af"

inherit pypi setuptools3

PYPI_PACKAGE = "pydoods"
