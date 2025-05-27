SUMMARY = "Library implementing a Zigbee stack"
HOMEPAGE = "https://github.com/zigpy/zigpy"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI:append = " file://0001-Allow-setuptools-git-versioning-3.patch"
SRC_URI[sha256sum] = "2da5f7e3fe77f61d993b2127361e528fb8f4772066266d3aedda8d0939dbdc0f"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "zigpy"

RDEPENDS:${PN} = "\
    python3-attrs \
    python3-aiohttp \
    python3-aiosqlite (>=0.20.0) \
    python3-crccheck \
    python3-cryptography \
    python3-voluptuous \
    python3-jsonschema \
    python3-pyserial-asyncio \
    python3-typing-extensions \
    python3-frozendict \
"
