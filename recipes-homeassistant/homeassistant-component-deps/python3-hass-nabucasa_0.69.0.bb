DESCRIPTION = "Issues related to the cloud integration in Nabu Casa"
HOMEPAGE = "https://github.com/NabuCasa/hass-nabucasa/tree/0.63.0"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=2e929b76b78cb8819ec868015bed9d96"

inherit pypi setuptools3

SRC_URI[sha256sum] = "100fd773613311ecaef69fcbff4db0b0a337819fce6164198c143791b7dbf54d"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-pycognito (=2022.12.0) \
    ${PYTHON_PN}-snitun (>=0.35.0) \
    ${PYTHON_PN}-acme (=1.31.0) \
    ${PYTHON_PN}-cryptography (>=2.8) \
    ${PYTHON_PN}-attrs (>=19.3) \
    ${PYTHON_PN}-aiohttp (>=3.6.1) \
    ${PYTHON_PN}-atomicwrites-homeassistant (=1.4.1) \ 
"
