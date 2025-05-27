DESCRIPTION = "JOSE protocol implementation in Python using cryptography."
HOMEPAGE = "https://github.com/certbot/josepy"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d2c2a5517cd7fd190a1aa6dfa23abb7a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi setuptools3 ptest-python-pytest

SRC_URI[sha256sum] = "e7d7acd2fe77435cda76092abe4950bb47b597243a8fb733088615fa6de9ec40"

RDEPENDS:${PN} = "\
    python3-cryptography (>=1.5) \
    python3-pyopenssl (>=0.13) \
"
