SUMMARY = "A utility for mocking out the Python HTTPX and HTTP Core libraries."
HOMEPAGE = "https://lundberg.github.io/respx/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=8c1e10a26712c34121879d038786a67b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3c8924caa2a50bd71aefc07aa812f2466ff489f1848c96e954a5362d17095d91"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-httpx \
"
PYPI_PACKAGE = "respx"
