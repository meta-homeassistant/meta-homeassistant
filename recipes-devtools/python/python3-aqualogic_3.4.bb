SUMMARY = "Library for interfacing with a Hayward/Goldline AquaLogic/ProLogic pool controller."
HOMEPAGE = "https://github.com/swilson/aqualogic"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=ef8be630b2d5a78ebbc378e662c76399"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "293819382defdc43cf53a30abbda7ac84657f4ee4ccea9764143b065b707a7f4"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp python3-pyserial python3-websockets"

PYPI_PACKAGE = "aqualogic"
