SUMMARY = "Python API for talking to Ecobee thermostats"
HOMEPAGE = "https://github.com/nkgilley/python-ecobee-api"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3f8a87dd19c26a92634df2aa8a6daba5"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a20adfcdf947d1196faf39abf5a762bd5a883e512f81cde4f43b7571b45cf3b6"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-requests (>=2.25)"

PYPI_PACKAGE = "python_ecobee_api"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
