SUMMARY = "Package to integrate with Flume Sensor"
HOMEPAGE = "https://github.com/ChrisMandich/PyFlume"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6afc05073e74a6c51ea5a9a435159e13"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a02883a9a37b00c54ee59bdae319b105e49143db37801e211596cf759239d0a5"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "python3-pyjwt python3-ratelimit python3-requests"
