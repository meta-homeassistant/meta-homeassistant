SUMMARY = "Python Interface for forked-daapd"
HOMEPAGE = "http://github.com/uvjustin/pyforked-daapd/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=04b41c2657ef501f8a71220d77bcb9c2"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "bf534e9703fc2ad06c422ab06f1d72f29f2500112e10974d86f476906ccbc4ab"

DEPENDS += "python3-aiohttp-native"

inherit pypi setuptools3
