SUMMARY = "Pythonic bindings for FFmpeg's libraries."
HOMEPAGE = "https://github.com/PyAV-Org/PyAV"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=a9c4cea4308c4521674ecd7c3255d8af"

SRC_URI[sha256sum] = "24c8c7ebe1bf57838a1316fec5039010b74ae0b3db41133448756f4b6579f48f"

inherit pypi python_setuptools_build_meta pkgconfig

DEPENDS += "\
    ${PYTHON_PN}-cython-native \
    ffmpeg \
"

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-numpy \
    ${PYTHON_PN}-pillow \
"
