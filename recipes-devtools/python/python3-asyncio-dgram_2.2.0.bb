SUMMARY = "Higher level Datagram support for Asyncio"
HOMEPAGE = "https://github.com/jsbronder/asyncio-dgram"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=84269accad9b3f5fa6876559ef0a3147"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "73362b491786153d8b888936c5780548b40b4e6f5e0d62bfef956cb7b6ed9684"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "python3-setuptools"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
"
