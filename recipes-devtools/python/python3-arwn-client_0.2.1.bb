SUMMARY = "Python client library for parsing ARWN weather station MQTT messages"
DESCRIPTION = "Python client library for parsing ARWN weather station MQTT \
    messages."
HOMEPAGE = "https://github.com/sdague/arwn-client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b9df07e6a45e6b3099ca66710c5b494a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a7440aa2bc352b5a8ce3706995a548373fbc79343fad34bf628217e18a7d3e37"

inherit pypi python_setuptools_build_meta ptest-python-pytest

DEPENDS += "python3-wheel-native"

RDEPENDS:${PN} += "\
    python3-click \
    python3-paho-mqtt \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-cov \
"

# The pytest configuration lives in pyproject.toml.
do_install_ptest:append() {
    install -m 0644 ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
