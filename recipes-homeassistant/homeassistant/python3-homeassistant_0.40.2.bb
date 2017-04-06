SUMMARY = "Open-source home automation platform running on Python 3"
HOMEPAGE = "https://home-assistant.io/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
# TODO: https://github.com/home-assistant/home-assistant/pull/6514
#LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"
LIC_FILES_CHKSUM = "file://README.rst;md5=1c78d1df746ca803a79ee5b00720230a"

HOMEASSISTANT_CONFIG_DIR ?= "${localstatedir}/lib/homeassistant"
HOMEASSISTANT_CONFIG_DIR[doc] = "Configuration directory used by home-assistant."
HOMEASSISTANT_USER ?= "homeassistant"
HOMEASSISTANT_USER[doc] = "User the home-assistent service runs as."

inherit setuptools3 useradd update-rc.d systemd

inherit pypi
SRC_URI[md5sum] = "dfe6ecea69c1b576b21552a87d280059"
SRC_URI[sha256sum] = "75c03b65eab015e6c91ce523e0b3ac24a915b132562f8b04dfeeac8a84db262c"

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
    install -d -o homeassistant -g homeassistant ${D}${HOMEASSISTANT_CONFIG_DIR}

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
    python3-requests (>= 2) \
    python3-pyyaml (>= 3.11)  \
    python3-pytz (>= 2016.10) \
    python3-pip (>= 7.1.0) \
    python3-jinja2 (>= 2.9.5) \
    python3-voluptuous (= 0.9.3) \
    python3-typing (>= 3) \
    python3-aiohttp (= 1.3.3)\
    python3-async-timeout (= 1.1.0) \
    \
    python3-asyncio \
    python3-multiprocessing \
    python3-sqlite3 \
    python3-html \
    "


# homeassistant.components.http
RDEPENDS_${PN} += " \
    python3-aiohttp-cors (= 0.5.0) \
    "

# homeassistant.components.recorder
# homeassistant.scripts.db_migrator
RDEPENDS_${PN} += " \
    python3-sqlalchemy (>= 1.1.5) \
    "

# homeassistant.components.discovery
RDEPENDS_${PN} += " \
    python3-netdisco (= 0.9.2) \
    "

# homeassistant.components.sun
RDEPENDS_${PN} += " \
    python3-astral (= 1.3.4) \
    "

# homeassistant.components.sensor.swiss_hydrological_data
# homeassistant.components.sensor.ted5000
# homeassistant.components.sensor.yr
RDEPENDS_${PN} += " \
    python3-xmltodict (= 0.10.2)\
    "

# homeassistant.components.updater
RDEPENDS_${PN} += " \
    python3-distro (= 1.0.2) \
    "

# homeassistant.components.conversation
RDEPENDS_${PN} += " \
    python3-fuzzywuzzy (= 0.15.0) \
    "

# homeassistant.components.tts.google
RDEPENDS_${PN} += " \
    python3-gtts-token (= 1.1.1) \
    "

# homeassistant.components.google
RDEPENDS_${PN} += " \
    python3-oauth2client (= 4.0.0)\
    "

# homeassistant.components.google
RDEPENDS_${PN} += " \
    python3-google-api-python-client (= 1.6.2) \
    "

# homeassistant.components.light.hue
RDEPENDS_${PN} += " \
    python3-phue (= 0.9) \
    "

# homeassistant.components.hdmi_cec
RDEPENDS_${PN} += " \
    python3-pycec (= 0.4.13) \
    "

# homeassistant.components.knx
RDEPENDS_${PN} += " \
    python3-knxip (= 0.3.3) \
    "

# homeassistant.components.netatmo
RDEPENDS_${PN} += " \
    python3-lnetatmo (= 0.9.1) \
    "

# homeassistant.components.mystrom
RDEPENDS_${PN} += " \
    python3-mystrom (= 0.3.6) \
    "

# homeassistant.scripts.check_config
RDEPENDS_${PN} += " \
    python3-colorlog (>= 2.10.0) \
    "

# homeassistant.components.lifx
RDEPENDS_${PN} += " \
    python3-liffylights (= 0.9.4)  \
    "
