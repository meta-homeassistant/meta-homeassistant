SUMMARY = "Library implementing Zigpy quirks for ZHA in Home Assistant"
HOMEPAGE = "https://github.com/zigpy/zha-device-handlers"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI:append = " file://0001-Allow-setuptools-git-versioning-3.patch"
SRC_URI[sha256sum] = "a856311a78e5d3ea57db4034ec4d19202d299ab620b774e4ffd6b9fe9d0c2c3f"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "zha_quirks"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} += "\
    python3-zigpy (>=0.74.0) \
"
