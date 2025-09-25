SUMMARY = "Controlling Energenie Power Strips with python."
HOMEPAGE = "https://github.com/gnumpi/pyegps"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-setuptools-scm-native"
SRC_URI[sha256sum] = "03b2164300af29e15bea2f5841b93b156140c3938f2cf489c388cce0341503ed"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "python3-pyusb"

PYPI_PACKAGE = "pyEGPS"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
