SUMMARY = "Open-source home automation platform running on Python 3"
HOMEPAGE = "https://home-assistant.io/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"

HOMEASSISTANT_CONFIG_DIR ?= "${localstatedir}/lib/homeassistant"
HOMEASSISTANT_CONFIG_DIR[doc] = "Configuration directory used by home-assistant."
HOMEASSISTANT_USER ?= "homeassistant"
HOMEASSISTANT_USER[doc] = "User the home-assistent service runs as."

inherit setuptools3 useradd update-rc.d systemd

inherit pypi

SRC_URI[md5sum] = "1e02917c660203e94417da7fd43322bb"
SRC_URI[sha256sum] = "cd3390cafc89f016c83fb6f5239c07a16fc447ce4f58c74783ff5dfbcfaa58ea"

SRC_URI += "\
    file://homeassistant.service \
    file://homeassistant.init \
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
    ${PYTHON_PN}-pyjwt (>=1.7.1) \
    ${PYTHON_PN}-aiohttp (>=3.6.1) \
    ${PYTHON_PN}-aiohttp-cors (>=0.7.0) \
    ${PYTHON_PN}-astral (>=1.10.1) \
    ${PYTHON_PN}-async-timeout (>=3.0.1) \
    ${PYTHON_PN}-async-upnp-client (>=0.14.12) \
    ${PYTHON_PN}-attrs (>=19.3.0) \
    ${PYTHON_PN}-bcrypt (>=3.1.7) \
    ${PYTHON_PN}-certifi (>=2019.11.28) \
    ${PYTHON_PN}-ciso8601 (>=2.1.3) \
    ${PYTHON_PN}-cryptography (>=2.8) \
    ${PYTHON_PN}-defusedxml (>=0.6.0) \
    ${PYTHON_PN}-distro (>=1.4.0) \
    ${PYTHON_PN}-importlib-metadata (>=1.5.0) \
    ${PYTHON_PN}-jinja2 (>=2.10.3) \
    ${PYTHON_PN}-mutagen (>=1.44.0) \
    ${PYTHON_PN}-netdisco (>=2.6.0) \
    ${PYTHON_PN}-pip (>=8.0.3) \
    ${PYTHON_PN}-pymetno (>=0.5.0) \
    ${PYTHON_PN}-pynacl (>=1.3.0) \
    ${PYTHON_PN}-python-slugify (>=3.0.3) \
    ${PYTHON_PN}-pytz (>=2019.02) \
    ${PYTHON_PN}-pyyaml (= 5.3) \
    ${PYTHON_PN}-requests (>=2.23.0) \
    ${PYTHON_PN}-ruamel-yaml (>=0.15.100) \
    ${PYTHON_PN}-samsungctl (>=0.7.1) \
    ${PYTHON_PN}-samsungtvws (>=1.4.0) \
    ${PYTHON_PN}-samsungtv (>=1.0.0) \
    ${PYTHON_PN}-sqlalchemy (>=1.3.15) \
    ${PYTHON_PN}-ssdp (>=1.0.1) \
    ${PYTHON_PN}-text-unidecode (>=1.3) \
    ${PYTHON_PN}-voluptuous-serialize (>=2.3.0) \
    ${PYTHON_PN}-voluptuous (>=0.11.7) \
    ${PYTHON_PN}-xmltodict (>=0.12.0) \
    ${PYTHON_PN}-zeroconf (>=0.24.5) \
    ${PYTHON_PN}-pycryptodome (>=3.6.6) \
    ${PYTHON_PN}-hass-nabucasa (>=0.32.2) \
    \
    ${PYTHON_PN}-home-assistant-frontend (>=20200318.1) \
    \
    ${PYTHON_PN}-pycparser (>= 2.7) \
    ${PYTHON_PN}-modules \
    ${PYTHON_PN}-paho-mqtt \
    ${PYTHON_PN}-coronavirus \
    ${PYTHON_PN}-gtts-token \
    ${PYTHON_PN}-pycognito \
    ${PYTHON_PN}-spotipy \
"
