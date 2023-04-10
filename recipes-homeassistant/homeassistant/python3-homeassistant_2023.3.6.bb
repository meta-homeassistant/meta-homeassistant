SUMMARY = "Open-source home automation platform running on Python 3"
HOMEPAGE = "https://home-assistant.io/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"

HOMEASSISTANT_CONFIG_DIR ?= "${localstatedir}/lib/homeassistant"
HOMEASSISTANT_CONFIG_DIR[doc] = "Configuration directory used by home-assistant."
HOMEASSISTANT_USER ?= "homeassistant"
HOMEASSISTANT_USER[doc] = "User the home-assistent service runs as."

SRC_URI[sha256sum] = "e0f4baa33caa25d745e89a7d70a4688d4b474d335ddf1a36a130dba28c100029"

SRC_URI:append = " \
    file://homeassistant.service \
"

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
# python3-pyjwt upstream version = 2.6.0
# python3-cryptography upstream version = 39.0.2
# python3-ifaddr upstream version = 0.2.0
# python3-yarl upstream version = 1.8.2

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-aiohttp (=3.8.4) \
    ${PYTHON_PN}-astral (=2.2) \
    ${PYTHON_PN}-async-timeout (=4.0.2) \
    ${PYTHON_PN}-atomicwrites-homeassistant (=1.4.1) \
    ${PYTHON_PN}-attrs (=22.2.0) \
    ${PYTHON_PN}-awesomeversion (=22.9.0) \
    ${PYTHON_PN}-bcrypt (=4.0.1) \
    ${PYTHON_PN}-certifi (>=2021.5.30) \
    ${PYTHON_PN}-ciso8601 (=2.3.0) \
    ${PYTHON_PN}-cryptography (>=39.0.1) \
    ${PYTHON_PN}-home-assistant-bluetooth (=1.9.3) \
    ${PYTHON_PN}-httpx (=0.23.3) \
    ${PYTHON_PN}-ifaddr (=0.2.0) \
    ${PYTHON_PN}-jinja2 (=3.1.2) \
    ${PYTHON_PN}-lru-dict (=1.1.8) \
    ${PYTHON_PN}-orjson (=3.8.7) \
    ${PYTHON_PN}-pip (>=21.0) \
    ${PYTHON_PN}-pyjwt (>=2.5.0) \
    ${PYTHON_PN}-pyopenssl (=23.0.0) \
    ${PYTHON_PN}-python-slugify (=4.0.1) \
    ${PYTHON_PN}-pyyaml (= 6.0) \
    ${PYTHON_PN}-requests (=2.28.2) \
    ${PYTHON_PN}-sqlite3 \
    ${PYTHON_PN}-statistics \
    ${PYTHON_PN}-typing-extensions (=4.5.0) \
    ${PYTHON_PN}-voluptuous (=0.13.1) \
    ${PYTHON_PN}-voluptuous-serialize (=2.6.0) \
    ${PYTHON_PN}-yarl (>=1.8.1) \
    ${PYTHON_PN}-zoneinfo \
"

require components/ha-component-cloud.inc
require components/ha-component-dhcp.inc
require components/ha-component-file_upload.inc
require components/ha-component-hardware.inc
require components/ha-component-http.inc
require components/ha-component-image_upload.inc
require components/ha-component-recorder.inc
require components/ha-component-ssdp.inc
require components/ha-component-tts.inc
require components/ha-component-usb.inc
require components/ha-component-zeroconf.inc
require components/ha-component-conversation.inc
