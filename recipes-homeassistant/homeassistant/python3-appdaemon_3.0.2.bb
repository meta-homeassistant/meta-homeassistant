inherit setuptools3

SUMMARY = "Apps for the Home Assistant home automation package"
HOMEPAGE = "https://github.com/home-assistant/appdaemon.git"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

inherit pypi

SRC_URI[md5sum] = "383d59070a3c684ae572c2739861f4e4"
SRC_URI[sha256sum] = "c32d9139566cc8147c39196a18c317accd1f0b2ef8e6c0ff31bddd4bc0f80bd3"

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

