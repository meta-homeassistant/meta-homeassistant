SUMMARY = "Recognize faces from Python or from the command line"
HOMEPAGE = "https://github.com/ageitgey/face_recognition"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5350ad154eb80290f2faad56592be730"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5e5efdd1686aa566af0d3cc1313b131e4b197657a8ffd03669e6d3fad92705ec"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-click (>=6.0) \
    python3-pillow \
    python3-dlib (>=19.7) \
    python3-face-recognition-models (>=0.3.0) \
    python3-numpy \
"

PYPI_PACKAGE = "face_recognition"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
