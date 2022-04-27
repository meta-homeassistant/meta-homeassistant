DESCRIPTION = "ACME protocol implementation in Python."
HOMEPAGE = "https://github.com/certbot/certbot/tree/master/acme"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d2c2a5517cd7fd190a1aa6dfa23abb7a"

inherit pypi setuptools3

SRC_URI[md5sum] = "75a6659bce20e757bb7387105d4b4b66"
SRC_URI[sha256sum] = "a2fcb75d16de6804f4b4d773a457ee2f6434ebaf8fd1aa60862a91d4e8f73608"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-cryptography (>=1.2.3) \
    ${PYTHON_PN}-josepy (>=1.1.0) \
    ${PYTHON_PN}-pyopenssl (>=0.13.1) \
    ${PYTHON_PN}-pyrfc3339 \
    ${PYTHON_PN}-pytz \
    ${PYTHON_PN}-requests (>=2.6.0) \
    ${PYTHON_PN}-requests-toolbelt (>=0.3.0) \
"
