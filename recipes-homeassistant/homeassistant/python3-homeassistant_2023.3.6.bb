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
SRC_URI[sha256sum] = "e0f4baa33caa25d745e89a7d70a4688d4b474d335ddf1a36a130dba28c100029"

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

# Components which can be selected and used.
# Everything before the empty line is a necessary component for Home Assistant to be able to boot correctly
# Everything after the empty line is an optional component for Home Assistant to be used.
PACKAGECONFIG ??= "\
    backup \
    bluetooth \
    cloud \
    conversation \
    dhcp \
    file-upload \
    frontend \
    hardware \
    http \
    image-upload \
    mobile-app \
    recorder \
    ssdp \
    tts \
    usb \
    zeroconf \
    \
    cast \
    fritz \
    fritzbox \
    ipp \
    octoprint \
    upnp \
"

PACKAGECONFIG[cloud] = ",,, \
    ${PYTHON_PN}-hass-nabucasa (=0.61.0) \
    ${PYTHON_PN}-numpy (>=1.23.2) \
"

PACKAGECONFIG[conversation] = ",,, \
    ${PYTHON_PN}-hassil (=1.0.6) \
    ${PYTHON_PN}-home-assistant-intents (=2023.2.28) \
"

PACKAGECONFIG[dhcp] = ",,, \
    ${PYTHON_PN}-aiodiscover (=1.4.13) \
    ${PYTHON_PN}-scapy (=2.5.0) \
"

PACKAGECONFIG[file-upload] = ",,, \
    ${PYTHON_PN}-janus (=1.0.0) \
"

PACKAGECONFIG[frontend] = ",,, \
    ${PYTHON_PN}-home-assistant-frontend (=20230309.1) \
"

PACKAGECONFIG[hardware] = ",,, \
    ${PYTHON_PN}-psutil-home-assistant (=0.0.1) \
"

PACKAGECONFIG[http] = ",,, \
    ${PYTHON_PN}-aiohttp-cors (=0.7.0) \
"

PACKAGECONFIG[image-upload] = ",,, \
    ${PYTHON_PN}-pillow (=9.4.0) \
"

PACKAGECONFIG[mobile-app] = ",,, \
    ${PYTHON_PN}-pynacl (=1.5.0) \
"

# python3-sqlalchemy upstream version = 2.0.7
PACKAGECONFIG[recorder] = ",,, \
    ${PYTHON_PN}-sqlalchemy (>=2.0.6) \
    ${PYTHON_PN}-fnvhash (=0.1.0) \
"

PACKAGECONFIG[ssdp] = ",,, \
    ${PYTHON_PN}-async-upnp-client (=0.33.1) \
"

PACKAGECONFIG[tts] = ",,, \
    ${PYTHON_PN}-mutagen (=1.46.0) \
    ${PYTHON_PN}-gtts (=2.2.4) \
"

PACKAGECONFIG[usb] = ",,, \
    ${PYTHON_PN}-pyudev (>=0.23.2) \
    ${PYTHON_PN}-pyserial (=3.5) \
"

# python3-zerconf upstream version = 0.47.4
PACKAGECONFIG[zeroconf] = ",,, \
    ${PYTHON_PN}-zeroconf (>=0.47.3) \
"

PACKAGECONFIG[bluetooth] = ",,, \
    ${PYTHON_PN}-bleak (=0.19.5) \
    ${PYTHON_PN}-bleak-retry-connector (=2.13.0) \
    ${PYTHON_PN}-bluetooth-adapters (=0.15.2) \
    ${PYTHON_PN}-bluetooth-auto-recovery (=1.0.3) \
    ${PYTHON_PN}-bluetooth-data-tools (=0.3.1) \
    ${PYTHON_PN}-dbus-fast (=1.84.1) \
"

PACKAGECONFIG[backup] = ",,, \
    ${PYTHON_PN}-securetar (=2022.2.0) \
"

PACKAGECONFIG[ipp] = ",,, \
    ${PYTHON_PN}-pyipp (=0.12.1) \
"

PACKAGECONFIG[cast] = ",,, \
    ${PYTHON_PN}-pychromecast (=13.0.4) \
"

PACKAGECONFIG[upnp] = ",,, \
    ${PYTHON_PN}-async-upnp-client (=0.33.1) \
    ${PYTHON_PN}-getmac (=0.8.2) \
"

PACKAGECONFIG[octoprint] = ",,, \
    ${PYTHON_PN}-pyoctoprintapi (=0.1.11) \
"

PACKAGECONFIG[fritz] = ",,, \
    ${PYTHON_PN}-fritzconnection (=1.11.0) \
    ${PYTHON_PN}-xmltodict (=0.13.0) \
"

PACKAGECONFIG[fritzbox] = ",,, \
    ${PYTHON_PN}-pyfritzhome (=0.6.7) \
"

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
    ${PYTHON_PN}-tzdata \
    ${PYTHON_PN}-voluptuous (=0.13.1) \
    ${PYTHON_PN}-voluptuous-serialize (=2.6.0) \
    ${PYTHON_PN}-yarl (>=1.8.1) \
    ${PYTHON_PN}-zoneinfo \
"
