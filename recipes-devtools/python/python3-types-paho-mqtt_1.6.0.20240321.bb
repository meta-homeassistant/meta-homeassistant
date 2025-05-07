SUMMARY = "Typing stubs for paho-mqtt"
HOMEPAGE = "https://github.com/python/typeshed"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=6;endline=6;md5=ef4dc1e740f5c928f1608a4a9c7b578e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "694eec160340f2a2b151237dcc3f107a63e1c4e5b8f9fcda0ba392049af9cbec"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-core"

PYPI_PACKAGE = "types-paho-mqtt"
