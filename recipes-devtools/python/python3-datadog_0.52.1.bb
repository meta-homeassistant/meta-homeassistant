SUMMARY = "The Datadog Python library"
HOMEPAGE = "https://github.com/DataDog/datadogpy"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f43807b7b811f8dc202e6e17701027d3"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "44c6deb563c4522dba206fba2e2bb93d3b04113c40191851ba3a241d82b5fd0b"

inherit pypi python_hatchling ptest-python-pytest

PYPI_PACKAGE = "datadog"
RDEPENDS:${PN} = "\
    python3-requests (>=2.6.0) \
"

RDEPENDS:${PN}-ptest = "\
    python3-click \
    python3-freezegun \
    python3-mock \
    python3-dateutil \
"
#python3-pytest-vcr
# python3-vcrpy
