SUMMARY = "A utility for mocking out the Python HTTPX and HTTP Core libraries."
HOMEPAGE = "https://lundberg.github.io/respx/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=8c1e10a26712c34121879d038786a67b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "242dcc6ce6b5b9bf621f5870c82a63997e8e82bc7c947f9ffe272b8f3dd5a780"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-httpx \
"
