SUMMARY = "Library implementing Zigpy quirks for ZHA in Home Assistant"
HOMEPAGE = "https://github.com/zigpy/zha-device-handlers"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI:append = " file://0001-Allow-setuptools-git-versioning-3.patch"
SRC_URI[sha256sum] = "8d2b27cb70481569207b0474edcb446bcdb8f2818a9497bd3d1b7ad1c7628aae"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "zha_quirks"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} += "\
    python3-zigpy (>=0.74.0) \
"
