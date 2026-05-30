SUMMARY = "Pure python memcached client"
HOMEPAGE = "https://github.com/linsomniac/python-memcached"
LICENSE = "PSF-2.0"
LIC_FILES_CHKSUM = "file://PSF.LICENSE;md5=03e566532476d47eb679b08f0c948240"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/linsomniac/python-memcached.git;protocol=https;branch=master"
SRCREV = "5c5cb1bc965c941f93b166d7ab2c055e3d8261e0"

inherit setuptools3 ptest-python-pytest
