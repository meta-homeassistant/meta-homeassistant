DESCRIPTION = "JOSE protocol implementation in Python using cryptography."
HOMEPAGE = "https://github.com/certbot/josepy"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d2c2a5517cd7fd190a1aa6dfa23abb7a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi setuptools3 ptest-python-pytest

SRC_URI[sha256sum] = "9beafbaa107ec7128e6c21d86b2bc2aea2f590158e50aca972dca3753046091f"

RDEPENDS:${PN} = "\
    python3-cryptography (>=1.5) \
    python3-pyopenssl (>=0.13) \
"
