DESCRIPTION = "ACME protocol implementation in Python."
HOMEPAGE = "https://github.com/certbot/certbot/tree/master/acme"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d2c2a5517cd7fd190a1aa6dfa23abb7a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "906e6cca7f58b5526c0ddfe3d71a7a41f8fa10acf3b083dd35cf619b5b015ca8"

RDEPENDS:${PN} = "\
    python3-cryptography (>=43.0.0) \
    python3-josepy (>=2.0.0) \
    python3-pyopenssl (>=25.0.0) \
    python3-pyrfc3339 \
    python3-requests (>=2.25.1) \
"
