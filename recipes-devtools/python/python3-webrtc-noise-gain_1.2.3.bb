SUMMARY = "Tiny wrapper around webrtc-audio-processing for noise suppression/auto gain only"
HOMEPAGE = "https://github.com/rhasspy/webrtc-noise-gain"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2aa2bed6f8750823223a2c11d7bc90c5"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS += "\
    python3-pybind11-native \
"

inherit pypi python_setuptools_build_meta

PYPI_SRC_URI = "git://github.com/rhasspy/webrtc-noise-gain.git;protocol=https;branch=master"

SRC_URI:aarch64 += "file://0001-Fix-machine-when-crosscompiling.patch"
SRCREV = "32a122569ca3ac55177570c30626d27f6dd1fc1a"

PV = "1.2.3+git0.32a122569ca3"

S = "${WORKDIR}/git"
