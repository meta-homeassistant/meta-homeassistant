DESCRIPTION = "ACME protocol implementation in Python."
HOMEPAGE = "https://github.com/certbot/certbot/tree/master/acme"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d2c2a5517cd7fd190a1aa6dfa23abb7a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi setuptools3

SRC_URI[sha256sum] = "c026edc0db13a36fb80d802d2e0256525b52272543beca3b8ddf2264bd8ef1f8"

RDEPENDS:${PN} = "\
    python3-cryptography (>=3.2.1) \
    python3-josepy (>=1.13.0) \
    python3-pyopenssl (>=17.5.0) \
    python3-pyrfc3339 \
    python3-pytz (>=2019.3) \
    python3-requests (>=2.20.0) \
    python3-setuptools (>=41.6.0) \
"
