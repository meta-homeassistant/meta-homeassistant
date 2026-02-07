SUMMARY = "An audio library based on libsndfile, CFFI and NumPy"
HOMEPAGE = "https://github.com/bastibe/python-soundfile"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=50c87fd45f9555bc1ffe01fe22be78d2"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b2c68dab1e30297317080a5b43df57e302584c49e2942defdde0acccc53f0e5b"

DEPENDS += "python3-cffi-native"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-cffi \
    python3-numpy \
    libsndfile1 \
"

PYPI_PACKAGE = "soundfile"
