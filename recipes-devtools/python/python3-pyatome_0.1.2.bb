SUMMARY = "Get your energy consumption from Atome Linky device"
HOMEPAGE = "http://github.com/baqs/pyAtome/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-Create-PEP-517-installer.patch"
SRC_URI[sha256sum] = "0c69205ba7a687f7ac65afda9548c16e92d7954e045483e4cac9fd6b42e0709e"

inherit pypi python_setuptools_build_meta

DEPENDS += "\
    python3-requests-native \
    python3-charset-normalizer-native \
"

RDEPENDS:${PN} += "\
    python3-fake-useragent \
    python3-requests \
    python3-simplejson \
"

PYPI_PACKAGE = "pyAtome"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
