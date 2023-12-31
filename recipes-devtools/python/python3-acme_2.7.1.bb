DESCRIPTION = "ACME protocol implementation in Python."
HOMEPAGE = "https://github.com/certbot/certbot/tree/master/acme"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d2c2a5517cd7fd190a1aa6dfa23abb7a"

inherit pypi setuptools3

SRC_URI[sha256sum] = "47aea91999434cb01a3530c7c76866f387fdb818097808704d6cfa98dbe4e966"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-cryptography (>=3.2.1) \
    ${PYTHON_PN}-josepy (>=1.13.0) \
    ${PYTHON_PN}-pyopenssl (>=17.5.0) \
    ${PYTHON_PN}-pyrfc3339 \
    ${PYTHON_PN}-pytz (>=2019.3) \
    ${PYTHON_PN}-requests (>=2.20.0) \
"
