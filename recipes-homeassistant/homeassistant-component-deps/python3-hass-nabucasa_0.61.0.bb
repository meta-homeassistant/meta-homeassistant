DESCRIPTION = "Issues related to the cloud integration in Nabu Casa"
HOMEPAGE = "https://github.com/NabuCasa/hass-nabucasa/tree/0.63.0"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=2e929b76b78cb8819ec868015bed9d96"

inherit pypi setuptools3

SRC_URI[md5sum] = "6e34a13df4500643ff8b33658222942c"
SRC_URI[sha256sum] = "17e8300b5e92dc9f56a07263d9bb19c4fc8132a6053618b3d53a274ea15b4f0b"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-acme (=1.31.0) \
    ${PYTHON_PN}-attrs (>=19.3) \
    ${PYTHON_PN}-cryptography (>=2.8) \
    ${PYTHON_PN}-snitun (>=0.31.0) \
    ${PYTHON_PN}-atomicwrites-homeassistant (=1.4.1) \
    ${PYTHON_PN}-aiohttp (>=3.6.1) \
    ${PYTHON_PN}-pycognito (=2022.8.0) \
"
