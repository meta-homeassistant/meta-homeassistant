SUMMARY = "Open-source home automation platform running on Python 3"
HOMEPAGE = "https://home-assistant.io/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"

HOMEASSISTANT_CONFIG_DIR ?= "${localstatedir}/lib/homeassistant"
HOMEASSISTANT_CONFIG_DIR[doc] = "Configuration directory used by home-assistant."
HOMEASSISTANT_USER ?= "homeassistant"
HOMEASSISTANT_USER[doc] = "User the home-assistent service runs as."

inherit setuptools3 useradd update-rc.d systemd

inherit pypi
SRC_URI[md5sum] = "9eff7efc1da062b633e4d0c983da9c38"
SRC_URI[sha256sum] = "c64b8eb6241a0f7a61383ba6c2f7d0ce7fa47b2321cdc4751fca82f253382f0e"

SRC_URI += "\
    file://homeassistant.service \
    file://homeassistant.init \
    file://0001-remove-typing-it-is-already-included-in-python-3.5.patch \
    "

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "homeassistant"
USERADD_PARAM_${PN} = "--system --home ${HOMEASSISTANT_CONFIG_DIR} \
                       --no-create-home --shell /bin/false \
                       --groups homeassistant,dialout --gid homeassistant ${HOMEASSISTANT_USER}"

INITSCRIPT_NAME = "homeassistant"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "homeassistant.service"

do_install_append () {
    install -d -o ${HOMEASSISTANT_USER} -g homeassistant ${D}${HOMEASSISTANT_CONFIG_DIR}

    # Install init scripts and set correct config directory
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/homeassistant.init  ${D}${sysconfdir}/init.d/homeassistant
    sed -i -e 's,@HOMEASSISTANT_CONFIG_DIR@,${HOMEASSISTANT_CONFIG_DIR},g'  ${D}${sysconfdir}/init.d/homeassistant
    sed -i -e 's,@HOMEASSISTANT_USER@,${HOMEASSISTANT_USER},g'  ${D}${sysconfdir}/init.d/homeassistant

    # Install systemd unit files and set correct config directory
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/homeassistant.service ${D}${systemd_unitdir}/system
    sed -i -e 's,@HOMEASSISTANT_CONFIG_DIR@,${HOMEASSISTANT_CONFIG_DIR},g' ${D}${systemd_unitdir}/system/homeassistant.service
    sed -i -e 's,@HOMEASSISTANT_USER@,${HOMEASSISTANT_USER},g' ${D}${systemd_unitdir}/system/homeassistant.service
}

# Home Assistant core
RDEPENDS_${PN} = " \
    python3-requests  \
    python3-pyyaml   \
    python3-pytz  \
    python3-pip \
    python3-jinja2  \
    python3-voluptuous  \
    python3-typing  \
    python3-aiohttp \
    python3-async-timeout  \
    python3-chardet \
    python3-astral (= 1.4) \
    \
    python3-asyncio \
    python3-multiprocessing \
    python3-sqlite3 \
    python3-html \
    "


# Component dependencies
RDEPENDS_${PN} += " \
    python3-aiohttp-cors  \
    python3-aiolifx \
    python3-colorlog \
    python3-distro  \
    python3-fuzzywuzzy  \
    python3-google-api-python-client  \
    python3-gtts-token \
    python3-hbmqtt \
    python3-knxip  \
    python3-liffylights \
    python3-lnetatmo \
    python3-mutagen \
    python3-mystrom \
    python3-netdisco \
    python3-oauth2client \
    python3-paho-mqtt \
    python3-phue \
    python3-pycec) \
    python3-pytradfri \
    python3-soco \
    python3-sqlalchemy \
    python3-xmltodict \
    "
