SUMMARY = "Open-source home automation platform running on Python 3"
HOMEPAGE = "https://home-assistant.io/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2aaba14ff23856010e6b6000a4e45fd6"

HOMEASSISTANT_CONFIG_DIR ?= "${localstatedir}/lib/homeassistant"
HOMEASSISTANT_CONFIG_DIR[doc] = "Configuration directory used by home-assistant."

inherit setuptools3 useradd systemd

SRCREV = "${AUTOREV}"
PV = "0.36.0+gitr${SRCPV}"
SRC_URI += "git://github.com/home-assistant/home-assistant.git;protocol=https;branch=dev"
S = "${WORKDIR}/git"

SRC_URI += "file://homeassistant.service"

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "homeassistant"
USERADD_PARAM_${PN} = "--system --home ${HOMEASSISTANT_CONFIG_DIR} \
                       --no-create-home --shell /bin/false \
                       --groups homeassistant,dialout --gid homeassistant homeassistant"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "homeassistant.service"

do_install_append () {
    install -d -o homeassistant -g homeassistant ${D}${HOMEASSISTANT_CONFIG_DIR}

    # Install systemd unit files and set correct config directory
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/homeassistant.service ${D}${systemd_unitdir}/system
    sed -i -e 's,@HOMEASSISTANT_CONFIG_DIR@,${HOMEASSISTANT_CONFIG_DIR},g' ${D}${systemd_unitdir}/system/homeassistant.service
}

# Home Assistant core
RDEPENDS_${PN} = " \
    python3-requests \
    python3-pyyaml  \
    python3-pytz \
    python3-jinja2 \
    python3-voluptuous \
    python3-typing \
    python3-aiohttp \
    python3-async-timeout \
    \
    python3-asyncio \
    python3-multiprocessing \
    python3-sqlite3 \
    \
    python3-pip \
    "


# homeassistant.components.http
RDEPENDS_${PN} += " \
    python3-aiohttp-cors \
    "

# homeassistant.components.recorder
# homeassistant.scripts.db_migrator
RDEPENDS_${PN} += " \
    python3-sqlalchemy \
    "

# homeassistant.components.discovery
RDEPENDS_${PN} += " \
    python3-netdisco \
    "

# homeassistant.components.sun
RDEPENDS_${PN} += " \
    python3-astral \
    "

# homeassistant.components.sensor.swiss_hydrological_data
# homeassistant.components.sensor.ted5000
# homeassistant.components.sensor.yr
RDEPENDS_${PN} += " \
    python3-xmltodict \
    "

# homeassistant.components.updater
RDEPENDS_${PN} += " \
    python3-distro \
    "

# homeassistant.components.conversation
RDEPENDS_${PN} += " \
    python3-fuzzywuzzy \
    "

# homeassistant.components.tts.google
RDEPENDS_${PN} += " \
    python3-gtts-token \
    "

# homeassistant.components.google
RDEPENDS_${PN} += " \
    python3-oauth2client \
    "

# homeassistant.components.google
RDEPENDS_${PN} += " \
    python3-google-api-python-client \
    "
