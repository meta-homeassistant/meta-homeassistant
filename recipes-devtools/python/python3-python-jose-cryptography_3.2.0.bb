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

SRC_URI[md5sum] = "382a4da9ec39a3fb872fd1cf672b8a57"
SRC_URI[sha256sum] = "4e4192402e100b5fb09de5a8ea6bcc39c36ad4526341c123d401e2561720335b"

RDEPENDS:${PN} = "\
    python3-pycryptodome \
"

RDEPENDS:${PN}-ptest += "\
    python3-ecdsa \
    python3-six \
    python3-pytest-runner \
"
