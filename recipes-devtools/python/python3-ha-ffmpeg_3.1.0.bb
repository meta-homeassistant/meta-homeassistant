SUMMARY = "A library that handling with ffmpeg for home-assistant"
HOMEPAGE = "https://github.com/pvizeli/ha-ffmpeg"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3f29f6595321db2f1333b32f61866572"

SRC_URI[sha256sum] = "b2178d62d9a9d696a7b61825a44a894dd68280605350946cc22925e61bbd93bb"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-async-timeout \
    ffmpeg \
"

PYPI_PACKAGE = "ha-ffmpeg"
