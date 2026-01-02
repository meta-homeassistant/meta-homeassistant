SUMMARY = "foscam camera cgi"
HOMEPAGE = "https://github.com/Foscam-wangzhengyu/libfoscamcgi"
LICENSE = "LGPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d61383c12730a97751c5c38ceca18ec826e9f649fd49681e9337706aa74cbcc4"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-defusedxml"

PYPI_PACKAGE = "libpyfoscamcgi"
