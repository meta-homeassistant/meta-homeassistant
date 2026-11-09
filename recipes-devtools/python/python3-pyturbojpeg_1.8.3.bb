SUMMARY = "A Python wrapper of libjpeg-turbo for decoding and encoding JPEG image."
HOMEPAGE = "https://github.com/lilohuang/PyTurboJPEG"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8f3b7be4986bb22e10ed020a103f1f2a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c131591a3990cc57f45a8b2705d6261c25df913a19b1fe88de5e911dbe04a1d4"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    libturbojpeg \
    python3-numpy \
"
