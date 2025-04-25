SUMMARY = "A Python3, async interface to the SimpliSafe API"
HOMEPAGE = "https://github.com/bachya/simplisafe-python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7f1047293ee76cb6043a1a4cfc6a4e44"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "6ab42d2bdb67f491c5197cf1a63aadb9b495002cbddfacb4ba4443c196b17096"

inherit pypi python_poetry_core

PYPI_PACKAGE = "simplisafe_python"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.9.0b0) \
    python3-backoff (>=1.11.1) \
    python3-certifi (>=2023.07.22) \
    python3-voluptuous (>=0.11.7) \
    python3-websockets (>=8.1) \
    python3-yarl (>=1.9.2) \
"
