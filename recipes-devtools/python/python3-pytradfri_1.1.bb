SUMMARY = "A python library for communicating with the Tradfri Gateway"
HOMEPAGE = "https://github.com/ggravlingen/pytradfri"
LICENSE = "MIT"
# TODO: Use real license file
LIC_FILES_CHKSUM = "file://setup.py;md5=174b2147bfd9d9b18846ab6d8baa0d32"

inherit pypi setuptools3

DEPENDS += "libcoap"

SRC_URI[md5sum] = "323db0446695db28dc85b290f088435e"
SRC_URI[sha256sum] = "9bb5adb41434a01e5b5e81e617ff82b2c8c1b7c29de4643bbab7f9a02dcd2245"
