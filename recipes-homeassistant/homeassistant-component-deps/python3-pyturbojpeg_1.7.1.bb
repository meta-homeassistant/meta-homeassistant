SUMMARY = "A Python wrapper of libjpeg-turbo for decoding and encoding JPEG image."
HOMEPAGE = "https://github.com/lilohuang/PyTurboJPEG"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e48b305b5643464d2faca48abbd59544"

SRC_URI[sha256sum] = "477bdda455ba628ee361e49e15caf777ea1770127c4d29af4d0afb1e3f9b6cc0"

inherit pypi setuptools3

PYPI_PACKAGE = "PyTurboJPEG"

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-numpy \
"
