SUMMARY = "Goal Zero REST Api Library"
HOMEPAGE = "https://github.com/tkdrob/goalzero"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e930503e1252372e439cbc2fa63a30b1"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "87f11a10e7b4cef9cee4161f708c82dd5abcb0f103eadb3521e23f18cfaf9bb7"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp (>=3.4.4)"
