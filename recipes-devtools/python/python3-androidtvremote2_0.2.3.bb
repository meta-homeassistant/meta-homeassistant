SUMMARY = "A Python library for interacting with Android TV using the Android TV Remote protocol v2"
HOMEPAGE = "https://github.com/tronikos/androidtvremote2"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "02e53aae8ec5d151ab4aff8a688040109aab6e1229353997d353b97aeb13550b"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "androidtvremote2"

RDEPENDS:${PN} = "\
    python3-aiofiles (>=0.8) \
    python3-cryptography (>=3) \
    python3-protobuf (>=4.21) \
"
