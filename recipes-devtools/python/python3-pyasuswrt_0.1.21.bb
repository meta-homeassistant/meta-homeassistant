SUMMARY = "Api wrapper for Asuswrt https://www.asus.com/ASUSWRT/ using protocol HTTP"
HOMEPAGE = "https://github.com/ollo69/pyasuswrt"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dcdb1b51136f4500a47367b303dd6b30"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "ffee28f789512eea42ce182ba6a89fa2f5a31a423daf4fdcf6bad48a813a196f"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp (>=3.7.4)"

PYPI_PACKAGE = "pyasuswrt"
