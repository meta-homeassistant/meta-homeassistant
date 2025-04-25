DESCRIPTION = "JOSE protocol implementation in Python using cryptography."
HOMEPAGE = "https://github.com/certbot/josepy"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d2c2a5517cd7fd190a1aa6dfa23abb7a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi setuptools3

SRC_URI[md5sum] = "d0f8dc9ffbf3ce0bd9c40e5ec1bf3516"
SRC_URI[sha256sum] = "8931daf38f8a4c85274a0e8b7cb25addfd8d1f28f9fb8fbed053dd51aec75dc9"

RDEPENDS:${PN} = "\
    python3-cryptography (>=1.5) \
    python3-pyopenssl (>=0.13) \
"
