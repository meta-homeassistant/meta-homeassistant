SUMMARY = "Pythonic bindings for FFmpeg's libraries."
HOMEPAGE = "https://github.com/PyAV-Org/PyAV"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=a9c4cea4308c4521674ecd7c3255d8af"

SRC_URI[sha256sum] = "1e33aefc0d54dc27e856ae95ab103adb5ffdc1793c8459d3156b5da6756816be"

inherit pypi python_setuptools_build_meta pkgconfig

DEPENDS += "\
    ${PYTHON_PN}-cython-native \
    ffmpeg \
"

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-numpy \
    ${PYTHON_PN}-pillow \
"
