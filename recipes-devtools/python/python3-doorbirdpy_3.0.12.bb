SUMMARY = "Python wrapper for the DoorBird LAN API"
HOMEPAGE = "https://gitlab.com/klikini/doorbirdpy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b28eb8fc319eb8f3e78193983dfb80bd"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://gitlab.com/klikini/doorbirdpy.git;protocol=https;tag=${PV};branch=master"
SRCREV = "5aaaf042c57e0592a6b5c45665fc313221e1330f"
SRC_URI[sha256sum] = "9b2685ac384f390852eb603375fd100446e4bc2cacb35af5a982423ffd31f002"

inherit setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp \
    python3-tenacity (>=9) \
"

RDEPENDS:${PN}-ptest = "\
    ${PN} \
    python3-pytest-asyncio \
    python3-aioresponses \
"
