SUMMARY = "Python API for controlling Leviton Decora Smart WiFi switches"
HOMEPAGE = "http://github.com/tlyakhov/python-decora_wifi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=7d28e72abfe86100a150e7c90c62388e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a16113b7366e78d242d254d674b7e4dd23aebe7aab27dc29e6b3923c9c47dcce"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-inflect \
    python3-requests \
"

PYPI_PACKAGE = "decora_wifi"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
