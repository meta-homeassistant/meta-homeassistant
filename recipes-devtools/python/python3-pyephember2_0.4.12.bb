SUMMARY = "Python library to work with ember from EPH Controls"
HOMEPAGE = "https://github.com/roberty99/pyephember2"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=8243bf8086b220567889d5044109d778"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c2cedcff95fa8a7d0a4b1a742327afb6bfb88260c7c441b8a810e1e30addaec5"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-paho-mqtt python3-requests"

PYPI_PACKAGE = "pyephember2"
