SUMMARY = "A library which communicates with XBee radios for zigpy"
HOMEPAGE = "https://github.com/zigpy/zigpy-xbee"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI += "file://0001-Allow-setuptools-git-versioning-3.patch \
           file://run-ptest \
           file://0002-tests-make-the-coordinator-mocks-pass-zigpy-s-type-c.patch \
           "
SRC_URI[sha256sum] = "267648c49e5945cfbadd884e1d255cb87498f55a534bbb8f66ac457fea2dc422"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "python3-zigpy (>=0.70.0)"

RDEPENDS:${PN}-ptest:append = " \
    python3-pytest-asyncio \
    python3-asynctest \
    python3-statistics \
    python3-sqlite3 \
"
