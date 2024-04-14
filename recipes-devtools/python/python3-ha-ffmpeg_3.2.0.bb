SUMMARY = "A library that handling with ffmpeg for home-assistant"
HOMEPAGE = "https://github.com/pvizeli/ha-ffmpeg"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3f29f6595321db2f1333b32f61866572"

SRC_URI[sha256sum] = "156f1696b8552feaf2ba91c02a28bc7ca064bbfeaec5dc35b8b08a52cce43f9d"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-async-timeout \
    ffmpeg \
"

PYPI_PACKAGE = "ha-ffmpeg"
