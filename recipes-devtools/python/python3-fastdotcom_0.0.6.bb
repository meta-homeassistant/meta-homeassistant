SUMMARY = "Python API for testing internet speed on Fast.com"
HOMEPAGE = "https://github.com/nkgilley/fast.com"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e6a600fd5e1d9cbde2d983680233ad02"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "0c08f9069f15960fcd4129f3d3217f9c79483bb912b47941001c2f4d61d5b08a"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-icmplib (>=3.0.0) \
    python3-requests (>=2.0) \
"

PYPI_PACKAGE = "fastdotcom"
