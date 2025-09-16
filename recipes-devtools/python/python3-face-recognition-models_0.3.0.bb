SUMMARY = "Models used by the face_recognition package."
HOMEPAGE = "https://github.com/ageitgey/face_recognition_models"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e12c025f33913f2167514339be62c3fd"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b79bd200a88c87c9a9d446c990ae71c5a626d1f3730174e6d570157ff1d896cf"

inherit pypi setuptools3

PYPI_PACKAGE = "face_recognition_models"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
