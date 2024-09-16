SUMMARY = "A Python wrapper of libjpeg-turbo for decoding and encoding JPEG image."
HOMEPAGE = "https://github.com/lilohuang/PyTurboJPEG"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5df3bb9cdf8813c063c798998565c764"

SRC_URI[sha256sum] = "5dd5f40dbf4159f41b6abaa123733910e8b1182df562b6ddb768991868b487d3"

inherit pypi setuptools3

PYPI_PACKAGE = "PyTurboJPEG"

RDEPENDS:${PN} += "\
    python3-numpy \
"
