DESCRIPTION = "ACME protocol implementation in Python."
HOMEPAGE = "https://github.com/certbot/certbot/tree/master/acme"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d2c2a5517cd7fd190a1aa6dfa23abb7a"

inherit pypi setuptools3

SRC_URI[md5sum] = "fa5324b7d7d3483cf9efb77615b849d7"
SRC_URI[sha256sum] = "f5e13262fa1101c38dd865378ac8b4639f819120eb66c5538fc6c09b7576fc53"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-cryptography (>=2.5.0) \
    ${PYTHON_PN}-josepy (>=1.13.0) \
    ${PYTHON_PN}-pyopenssl (>=17.5.0) \
    ${PYTHON_PN}-pyrfc3339 \
    ${PYTHON_PN}-pytz (>=2019.3) \
    ${PYTHON_PN}-requests (>=2.20.0) \
    ${PYTHON_PN}-requests-toolbelt (>=0.3.0) \
"
