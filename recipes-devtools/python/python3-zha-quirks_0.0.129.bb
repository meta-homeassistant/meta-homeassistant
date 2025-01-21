SUMMARY = "Library implementing Zigpy quirks for ZHA in Home Assistant"
HOMEPAGE = "https://github.com/zigpy/zha-device-handlers"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI += "file://0001-Allow-setuptools-git-versioning-3.patch"
SRC_URI[sha256sum] = "8b54ad856ee427fc0706b718dab03bf17d641fbc11c8029a5b7e8c7d0aff906b"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "zha_quirks"

RDEPENDS:${PN} += "\
    python3-zigpy (>=0.70.0) \
"
