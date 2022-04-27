DESCRIPTION = "Python class to integrate Boto3’s Cognito client so it is easy to login users. With SRP support."
HOMEPAGE = "https://github.com/capless/warrant"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://setup.py;md5=d781fd54312fe4e227a093bdcaa7b4fd"

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

inherit pypi setuptools3

SRC_URI[md5sum] = "1a25cf0c342870c6f2b4ea5522b3e8fd"
SRC_URI[sha256sum] = "749bde7f775c077a64edfe21464654e0a39fc93dd76e27d5d2a61997b6dcaa0a"

SRC_URI += "\
    file://0001-Remove-pip-requires.patch \
"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-boto3 (>=1.4.3) \
    ${PYTHON_PN}-envs (>=0.3.0) \
    ${PYTHON_PN}-python-jose-cryptodome (>=1.3.2) \
    ${PYTHON_PN}-requests (>=2.13.0) \
"
