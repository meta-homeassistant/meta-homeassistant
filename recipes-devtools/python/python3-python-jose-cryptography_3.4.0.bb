DESCRIPTION = "A JOSE implementation in Python"
HOMEPAGE = "https://github.com/mpdavis/python-jose/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1b2f485d31051eb5916a93212174c041"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta ptest-python-pytest

DEPENDS += "\
    python3-pytest-runner-native \
"

PYPI_PACKAGE = "python-jose"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

SRC_URI[sha256sum] = "9a9a40f418ced8ecaf7e3b28d69887ceaa76adad3bcaa6dae0d9e596fec1d680"

RDEPENDS:${PN} = "\
    python3-pycryptodome \
"

RDEPENDS:${PN}-ptest += "\
    python3-ecdsa \
    python3-six \
    python3-pytest-runner \
"
