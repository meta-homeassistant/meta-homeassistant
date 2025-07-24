SUMMARY = "Python Build Reasonableness"
HOMEPAGE = "https://docs.openstack.org/pbr/latest/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1dece7821bf3fd70fe1309eaa37d52a2"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "93ea72ce6989eb2eed99d0f75721474f69ad88128afdef5ac377eb797c4bf76b"

inherit pypi python_setuptools_build_meta

BBCLASSEXTEND = "native nativesdk"

PYPI_PACKAGE = "pbr"
