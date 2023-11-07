DESCRIPTION = "Issues related to the cloud integration in Nabu Casa"
HOMEPAGE = "https://github.com/NabuCasa/hass-nabucasa"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit pypi setuptools3

SRC_URI[sha256sum] = "a2d2ffed938e53b772e83bfcdda4505ae8fc597b58e275a092e961a777ba2311"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-pycognito (=2022.12.0) \
    ${PYTHON_PN}-snitun (>=0.35.0) \
    ${PYTHON_PN}-acme (=1.31.0) \
    ${PYTHON_PN}-cryptography (>=2.8) \
    ${PYTHON_PN}-attrs (>=19.3) \
    ${PYTHON_PN}-aiohttp (>=3.6.1) \
    ${PYTHON_PN}-atomicwrites-homeassistant (=1.4.1) \ 
"
