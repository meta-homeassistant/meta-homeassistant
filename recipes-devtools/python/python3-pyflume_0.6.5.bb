SUMMARY = "Package to integrate with Flume Sensor"
HOMEPAGE = "https://github.com/ChrisMandich/PyFlume"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6afc05073e74a6c51ea5a9a435159e13"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

# Home Assistant 2026.11 pins PyFlume 0.6.5. 0.8.x renamed the
# flume_token_file argument of FlumeAuth, which the flume integration
# still passes, so its setup fails with a TypeError.
PYPI_PACKAGE_SDIST = "PyFlume"

SRC_URI[sha256sum] = "9b28a282ee868b466c4916a27d298ebf0924dd411191d0ba0639230406374e3d"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "python3-pyjwt python3-pytz python3-ratelimit python3-requests"

# setup.py installs the test suite as a top-level "tests" package, which
# collides with other packages that do the same (python3-pycontrol4).
do_install:append() {
    rm -rf ${D}${PYTHON_SITEPACKAGES_DIR}/tests
}
