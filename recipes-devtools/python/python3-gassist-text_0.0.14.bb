SUMMARY = "A Python library for interacting with Google Assistant API via text"
HOMEPAGE = "https://github.com/tronikos/gassist_text"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a8d0240ac29c024b736d0f5a18a2d03ad5706640dd36f565031bf86c35095d79"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
	python3-google-auth (>=0.3.0) \
	python3-grpcio (>=1.48.0) \
	python3-protobuf (>=3.20.0) \
	python3-requests (>=2.20.0 ) \
"

PYPI_PACKAGE = "gassist_text"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
