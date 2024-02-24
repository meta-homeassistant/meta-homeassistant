SUMMARY = "Open-source home automation platform running on Python 3"
HOMEPAGE = "https://home-assistant.io/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"

HOMEASSISTANT_CONFIG_DIR ?= "${localstatedir}/lib/homeassistant"
HOMEASSISTANT_CONFIG_DIR[doc] = "Configuration directory used by home-assistant."
HOMEASSISTANT_USER ?= "homeassistant"
HOMEASSISTANT_USER[doc] = "User the home-assistent service runs as."

SRC_URI += "\
    file://homeassistant.service \
    file://0001-Update-pyproject.toml-to-allow-compilation.patch \
"
SRC_URI[sha256sum] = "4eca63a97f7c69d8ba7187bfada575141e57cb9f45e23589ba4c35a64b8ff92c"

inherit python_setuptools_build_meta pypi useradd systemd

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = "homeassistant"
USERADD_PARAM:${PN} = "\
    --system --home ${HOMEASSISTANT_CONFIG_DIR} \
    --no-create-home --shell /bin/false \
    --groups homeassistant,dialout --gid homeassistant ${HOMEASSISTANT_USER} \
"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "homeassistant.service"

do_install:append () {
    install -d -o ${HOMEASSISTANT_USER} -g homeassistant ${D}${HOMEASSISTANT_CONFIG_DIR}

    # Install systemd unit files and set correct config directory
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/homeassistant.service ${D}${systemd_unitdir}/system
    sed -i -e 's,@HOMEASSISTANT_CONFIG_DIR@,${HOMEASSISTANT_CONFIG_DIR},g' ${D}${systemd_unitdir}/system/homeassistant.service
    sed -i -e 's,@HOMEASSISTANT_USER@,${HOMEASSISTANT_USER},g' ${D}${systemd_unitdir}/system/homeassistant.service
}

# Home Assistant core
# Home Assistant contains thousands of integrations. These are subdivided in their own include file bases on the same division as HA itself uses
# at https://www.home-assistant.io/integrations/

require recipes-homeassistant/homeassistant/include/3d-printing.inc
require recipes-homeassistant/homeassistant/include/hacs.inc
require recipes-homeassistant/homeassistant/include/history.inc
require recipes-homeassistant/homeassistant/include/hub.inc
require recipes-homeassistant/homeassistant/include/image-processing.inc
require recipes-homeassistant/homeassistant/include/media-player.inc
require recipes-homeassistant/homeassistant/include/network.inc
require recipes-homeassistant/homeassistant/include/other.inc
require recipes-homeassistant/homeassistant/include/sensor.inc
require recipes-homeassistant/homeassistant/include/switch.inc
require recipes-homeassistant/homeassistant/include/system-monitor.inc
require recipes-homeassistant/homeassistant/include/text-to-speech.inc
require recipes-homeassistant/homeassistant/include/utility.inc
require recipes-homeassistant/homeassistant/include/voice.inc
require recipes-homeassistant/homeassistant/include/weather.inc

# There are two exceptions:
# - any integration which has multiple categories are grouped in multiple.inc
# - any integration which has no category assigned to it is in none.inc

require recipes-homeassistant/homeassistant/include/multiple.inc
require recipes-homeassistant/homeassistant/include/none.inc

RDEPENDS:${PN} += "\
    ${PYTHON_PN}-aiohttp (>=3.9.1) \
    ${PYTHON_PN}-aiohttp-cors (=0.7.0) \
    ${PYTHON_PN}-aiohttp-fast-url-dispatcher (=0.3.0) \
    ${PYTHON_PN}-aiohttp-zlib-ng (=0.1.1) \
    ${PYTHON_PN}-astral (=2.2) \
    ${PYTHON_PN}-attrs (>=23.1.0) \
    ${PYTHON_PN}-atomicwrites-homeassistant (=1.4.1) \
    ${PYTHON_PN}-awesomeversion (>=23.11.0) \
    ${PYTHON_PN}-bcrypt (>=4.0.1) \   
    ${PYTHON_PN}-certifi (>=2021.5.30) \
    ${PYTHON_PN}-ciso8601 (=2.3.0) \
    ${PYTHON_PN}-httpx (=0.25.0) \
    ${PYTHON_PN}-home-assistant-bluetooth (=1.10.4) \
    ${PYTHON_PN}-ifaddr (=0.2.0) \
    ${PYTHON_PN}-jinja2 (>=3.1.2) \
    ${PYTHON_PN}-lru-dict (>=1.2.0) \
    ${PYTHON_PN}-pyjwt (=2.8.0) \
    ${PYTHON_PN}-cryptography (>=41.0.7) \
    ${PYTHON_PN}-pyopenssl (>=23.2.0) \
    ${PYTHON_PN}-orjson (=3.9.9) \
    ${PYTHON_PN}-packaging (>=23.1) \
    ${PYTHON_PN}-pip (>=21.3.1) \
    ${PYTHON_PN}-python-slugify (=4.0.1) \
    ${PYTHON_PN}-pyyaml (=6.0.1) \
    ${PYTHON_PN}-requests (=2.31.0) \
    ${PYTHON_PN}-typing-extensions (>=4.8.0) \
    ${PYTHON_PN}-ulid-transform (=0.9.0) \
    ${PYTHON_PN}-voluptuous (=0.13.1) \
    ${PYTHON_PN}-voluptuous-serialize (=2.6.0) \
    ${PYTHON_PN}-yarl (>=1.9.2) \
    \
    ${PYTHON_PN}-statistics \
    ${PYTHON_PN}-core (>=3.11.0) \
" 