SUMMARY = "Pythonic bindings for FFmpeg's libraries."
HOMEPAGE = "https://github.com/PyAV-Org/PyAV"

LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=a9c4cea4308c4521674ecd7c3255d8af"

SRC_URI[sha256sum] = "41a30556f8258a9374906d7e65034a93b593c9d4b220f9f6a9adf652dbcb89dc"

inherit pypi python_setuptools_build_meta pkgconfig

DEPENDS += "\
    python3-cython-native \
    ffmpeg \
"

RDEPENDS:${PN} += "\
    python3-numpy \
    python3-pillow \
"
