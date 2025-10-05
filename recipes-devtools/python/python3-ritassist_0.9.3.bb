SUMMARY = "RitAssist API Access"
HOMEPAGE = "http://github.com/depl0y/ritassist-py"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d4908a59bfb799d4189cbdb9d0c97e905931e95025042ec52fa5dc42543e902e"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-ciso8601 python3-geopy python3-requests python3-sseclient"

PYPI_PACKAGE = "ritassist"
