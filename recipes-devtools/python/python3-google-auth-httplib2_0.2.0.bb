SUMMARY = "Google Authentication Library: httplib2 transport"
HOMEPAGE = "https://github.com/GoogleCloudPlatform/google-auth-library-python-httplib2"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "38aa7badf48f974f1eb9861794e9c0cb2a0511a4ec0679b1f886d108f5640e05"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-google-auth \
    python3-httplib2 (>=0.19.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-flask \
"

PYPI_PACKAGE = "google-auth-httplib2"
