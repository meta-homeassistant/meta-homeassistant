SUMMARY = "Library implementing a Zigbee stack"
HOMEPAGE = "https://github.com/zigpy/zigpy"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI:append = " file://0001-Allow-setuptools-git-versioning-3.patch"
SRC_URI[sha256sum] = "3111622e0658bc4201700b8cd52026c00d5deb9b93bc6f5bb545f6fc8a4b0140"

inherit pypi python_setuptools_build_meta

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
