inherit setuptools3

SUMMARY = "Apps for the Home Assistant home automation package"
HOMEPAGE = "https://github.com/home-assistant/appdaemon.git"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi

SRC_URI[md5sum] = "cfceac58b705dba5b828e83010b2a1d1"
SRC_URI[sha256sum] = "623897ce08dc2efe24d04380df36e4b7fb35c0e4007e882857d4047f0b60349d"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-aiohttp \
    ${PYTHON_PN}-aiohttp-jinja2 \
    ${PYTHON_PN}-async \
    ${PYTHON_PN}-astral \
    ${PYTHON_PN}-bcrypt \
    ${PYTHON_PN}-configparser \
    ${PYTHON_PN}-daemonize \
    ${PYTHON_PN}-feedparser \
    ${PYTHON_PN}-iso8601 \
    ${PYTHON_PN}-jinja2 \
    ${PYTHON_PN}-requests \
    ${PYTHON_PN}-sseclient \
    ${PYTHON_PN}-pyyaml \
    ${PYTHON_PN}-voluptuous \
    ${PYTHON_PN}-websockets \
    ${PYTHON_PN}-websocket-client \
"

