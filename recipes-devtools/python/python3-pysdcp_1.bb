SUMMARY = "SDCP library to control Sony Projectors"
HOMEPAGE = "https://github.com/Galala7/pySDCP"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=adc1f231c76ee2f1f36025d56926ba2c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "951fe67e7925c88f794b3934c0decf92836a5c9186e1adb2fa1104633535691c"

inherit pypi setuptools3

PYPI_PACKAGE = "pySDCP"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
