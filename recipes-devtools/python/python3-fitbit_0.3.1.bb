SUMMARY = "Fitbit API Wrapper."
HOMEPAGE = "https://github.com/orcasgit/python-fitbit"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0892a9e2649d17fbd75d54d3835799dd"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "ea09dc22bafccf5678c779dae93d6ed393a310847f9c7cb4a885f241312dde9b"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-dateutil (>=1.5) \
    python3-requests-oauthlib (>=0.7) \
    python3-setuptools \
"

PYPI_PACKAGE = "fitbit"
