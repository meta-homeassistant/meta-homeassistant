SUMMARY = "A library that returns a list of devices currently connected to a BT Home Hub 5"
HOMEPAGE = "https://github.com/ahobsonsayers/bthomehub5-devicelist"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=eca0f6a234f50cdd6f61eb35da7836c7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "6d63302db14674c45c64b2156cea6d58c38e1735419b62b143d8f0aaf014eb30"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-html-table-parser-python3 (>=0.1.5) \
    python3-requests \
"

PYPI_PACKAGE = "bthomehub5-devicelist"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
