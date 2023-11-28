SUMMARY = "Tiny wrapper around webrtc-audio-processing for noise suppression/auto gain only"
HOMEPAGE = "https://github.com/rhasspy/webrtc-noise-gain"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2aa2bed6f8750823223a2c11d7bc90c5"

DEPENDS += "\
    ${PYTHON_PN}-pybind11-native \
"

inherit pypi python_setuptools_build_meta

SRC_URI:aarch64 += "file://0001-Fix-machine-when-crosscompiling.patch"
SRC_URI[sha256sum] = "4282f79066774ebc30242d7174f0c53cdcfa984b68c88f586cd52cb2356c5e75"

PYPI_PACKAGE = "webrtc_noise_gain"
