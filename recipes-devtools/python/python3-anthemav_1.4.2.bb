SUMMARY = "Python API for controlling Anthem Receivers"
HOMEPAGE = "https://github.com/nugget/python-anthemav"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cd2e30fa8fe30da92b7e8e723114aa1c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "37cc503c22aa97fb4159a04996066f862848e366926748befa9e4631904a909f"

inherit pypi setuptools3

PYPI_PACKAGE = "anthemav"
