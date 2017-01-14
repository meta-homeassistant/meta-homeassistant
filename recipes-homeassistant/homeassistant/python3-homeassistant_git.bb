SUMMARY = "Open-source home automation platform running on Python 3"
HOMEPAGE = "https://home-assistant.io/"
SECTION = "devel/python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2aaba14ff23856010e6b6000a4e45fd6"

inherit setuptools3 useradd systemd

SRCREV = "${AUTOREV}"
PV = "0.36.0+gitr${SRCPV}"
SRC_URI += "git://github.com/home-assistant/home-assistant.git;protocol=https;branch=dev"
S = "${WORKDIR}/git"

SRC_URI += "file://homeassistant.service"

SRC_URI[md5sum] = "8b81c4be91a28bada412095cf3ca1f66"
SRC_URI[sha256sum] = "e2eb230b6597a17e200e91823f91cf48dcb71da9704b22577334236c31a0558b"

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM_${PN} = "homeassistant"
USERADD_PARAM_${PN} = "--system --home ${localstatedir}/lib/homeassistant \
                       --no-create-home --shell /bin/false \
                       --groups homeassistant,dialout --gid homeassistant homeassistant"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "homeassistant.service"

do_install_append () {
    install -d -o homeassistant -g homeassistant ${D}${localstatedir}/lib/homeassistant

    # Install systemd unit files
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${WORKDIR}/homeassistant.service ${D}${systemd_unitdir}/system
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
