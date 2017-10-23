inherit setuptools3

SUMMARY = "Apps for the Home Assistant home automation package"
HOMEPAGE = "https://github.com/home-assistant/appdaemon.git"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi

SRC_URI[md5sum] = "f608135ce0ce9dec95d67978aa156bb5"
SRC_URI[sha256sum] = "a5bdc2d68952b5df340c002a2182091caf2884630f1d1702c377b3b5a5860f34"

RDEPENDS_${PN} = "\
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

