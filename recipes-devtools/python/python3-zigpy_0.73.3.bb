SUMMARY = "Library implementing a Zigbee stack"
HOMEPAGE = "https://github.com/zigpy/zigpy"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI += "file://0001-Allow-setuptools-git-versioning-3.patch"
SRC_URI[sha256sum] = "1bdddd84fdcc09f04ec81a7cd6dfca1692c42849e3a2f25f87f82c8f88f8c4f5"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "zigpy"

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-aiosqlite (>=0.20.0) \
    python3-crccheck \
    python3-cryptography \
    python3-frozendict \
    python3-jsonschema \
    python3-pyserial-asyncio \
    python3-typing-extensions \
    python3-voluptuous \
    python3-attrs \
"
