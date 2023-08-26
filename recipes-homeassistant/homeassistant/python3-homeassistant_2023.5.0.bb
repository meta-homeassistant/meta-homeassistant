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
SRC_URI[sha256sum] = "cd338e42203d9d2249479f5f8e447593e24d3afa978755c1db58b89f342ae194"

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
PACKAGES += "\
    ${PN}-axis \
    ${PN}-backup \
    ${PN}-bluetooth \
    ${PN}-cast \
    ${PN}-cloud \
    ${PN}-conversation \
    ${PN}-dhcp \
    ${PN}-file-upload \
    ${PN}-fritz \
    ${PN}-fritzbox \
    ${PN}-frontend \
    ${PN}-google-translate \
    ${PN}-hardware \
    ${PN}-hacs \
    ${PN}-http \
    ${PN}-image-upload \
    ${PN}-ipp \
    ${PN}-met \
    ${PN}-mobile-app \
    ${PN}-octoprint \
    ${PN}-radio-browser \
    ${PN}-recorder \
    ${PN}-shelly \
    ${PN}-ssdp \
    ${PN}-stream \
    ${PN}-tts \
    ${PN}-upnp \
    ${PN}-usb \
    ${PN}-zeroconf \
"

ALLOW_EMPTY:${PN}-axis = "1"
RDEPENDS:${PN}-axis = "\
    ${PYTHON_PN}-axis (=47) \
"

ALLOW_EMPTY:${PN}-backup = "1"
RDEPENDS:${PN}-backup = "\
    ${PYTHON_PN}-securetar (=2023.3.0) \
"

ALLOW_EMPTY:${PN}-bluetooth = "1"
RDEPENDS:${PN}-bluetooth = "\
    ${PYTHON_PN}-bleak (=0.20.2) \
    ${PYTHON_PN}-bleak-retry-connector (=3.0.2) \
    ${PYTHON_PN}-bluetooth-adapters (=0.15.3) \
    ${PYTHON_PN}-bluetooth-auto-recovery (=1.1.1) \
    ${PYTHON_PN}-bluetooth-data-tools (=0.4.0) \
    ${PYTHON_PN}-dbus-fast (=1.85.0) \
"

ALLOW_EMPTY:${PN}-cast = "1"
RDEPENDS:${PN}-cast = "\
    ${PYTHON_PN}-pychromecast (=13.0.7) \
"

ALLOW_EMPTY:${PN}-cloud = "1"
RDEPENDS:${PN}-cloud = "\
    ${PYTHON_PN}-hass-nabucasa (=0.66.2) \
"

ALLOW_EMPTY:${PN}-conversation = "1"
RDEPENDS:${PN}-conversation = "\
    ${PYTHON_PN}-hassil (=1.0.6) \
    ${PYTHON_PN}-home-assistant-intents (=2023.4.26) \
"

ALLOW_EMPTY:${PN}-dhcp = "1"
RDEPENDS:${PN}-dhcp = "\
    ${PYTHON_PN}-aiodiscover (=1.4.16) \
    ${PYTHON_PN}-scapy (=2.5.0) \
"

ALLOW_EMPTY:${PN}-file-upload = "1"
RDEPENDS:${PN}-file-upload = "\
    ${PYTHON_PN}-janus (=1.0.0) \
"

ALLOW_EMPTY:${PN}-fritz = "1"
RDEPENDS:${PN}-fritz = "\
    ${PYTHON_PN}-fritzconnection (=1.12.0) \
    ${PYTHON_PN}-xmltodict (=0.13.0) \
"

ALLOW_EMPTY:${PN}-fritzbox = "1"
RDEPENDS:${PN}-fritzbox = "\
    ${PYTHON_PN}-pyfritzhome (=0.6.8) \
"

ALLOW_EMPTY:${PN}-frontend = "1"
RDEPENDS:${PN}-frontend = "\
    ${PYTHON_PN}-home-assistant-frontend (=20230503.1) \
"

ALLOW_EMPTY:${PN}-google-translate = "1"
RDEPENDS:${PN}-google-translate = "\
    ${PYTHON_PN}-gtts (=2.2.4) \
"

ALLOW_EMPTY:${PN}-hardware = "1"
RDEPENDS:${PN}-hardware = "\
    ${PYTHON_PN}-psutil-home-assistant (=0.0.1) \
"

ALLOW_EMPTY:${PN}-hacs = "1"
RDEPENDS:${PN}-hacs = "\
    ${PYTHON_PN}-aiogithubapi (=22.10.1) \
"

ALLOW_EMPTY:${PN}-http = "1"
RDEPENDS:${PN}-http = "\
    ${PYTHON_PN}-aiohttp-cors (=0.7.0) \
"

ALLOW_EMPTY:${PN}-image-upload = "1"
RDEPENDS:${PN}-image-upload = "\
    ${PYTHON_PN}-pillow (>=9.5.0) \
"

ALLOW_EMPTY:${PN}-ipp = "1"
RDEPENDS:${PN}-ipp = "\
    ${PYTHON_PN}-pyipp (=0.12.1) \
"

ALLOW_EMPTY:${PN}-met = "1"
RDEPENDS:${PN}-met = "\
    ${PYTHON_PN}-pymetno (>=0.9.0) \
"

ALLOW_EMPTY:${PN}-mobile-app = "1"
RDEPENDS:${PN}-mobile-app = "\
    ${PYTHON_PN}-pynacl (=1.5.0) \
"

ALLOW_EMPTY:${PN}-octoprint = "1"
RDEPENDS:${PN}-octoprint = "\
    ${PYTHON_PN}-pyoctoprintapi (=0.1.11) \
"

ALLOW_EMPTY:${PN}-radio-browser = "1"
RDEPENDS:${PN}-radio-browser = "\
    ${PYTHON_PN}-radios (=0.1.1) \
"

ALLOW_EMPTY:${PN}-recorder = "1"
RDEPENDS:${PN}-recorder = "\
    ${PYTHON_PN}-fnv-hash-fast (=0.3.1) \
    ${PYTHON_PN}-sqlalchemy (>=2.0.12) \
"

ALLOW_EMPTY:${PN}-shelly = "1"
RDEPENDS:${PN}-shelly = "\
    ${PYTHON_PN}-aioshelly (=5.3.2) \
"

ALLOW_EMPTY:${PN}-ssdp = "1"
RDEPENDS:${PN}-ssdp = "\
    ${PYTHON_PN}-async-upnp-client (=0.33.1) \
"

ALLOW_EMPTY:${PN}-stream = "1"
RDEPENDS:${PN}-stream = "\
    ${PYTHON_PN}-pyturbojpeg (=1.6.7) \
    ${PYTHON_PN}-ha-av (=10.0.0) \
    ${PYTHON_PN}-numpy (>=1.23.2) \
"

ALLOW_EMPTY:${PN}-tts = "1"
RDEPENDS:${PN}-tts = "\
    ${PYTHON_PN}-mutagen (=1.46.0) \
"

ALLOW_EMPTY:${PN}-upnp = "1"
RDEPENDS:${PN}-upnp = "\
    ${PYTHON_PN}-async-upnp-client (=0.33.1) \
    ${PYTHON_PN}-getmac (=0.8.2) \
"

ALLOW_EMPTY:${PN}-usb = "1"
RDEPENDS:${PN}-usb = "\
    ${PYTHON_PN}-pyserial (=3.5) \
    ${PYTHON_PN}-pyudev (>=0.23.2) \
"

ALLOW_EMPTY:${PN}-zeroconf = "1"
RDEPENDS:${PN}-zeroconf = "\
    ${PYTHON_PN}-zeroconf (>=0.58.2) \
"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-aiohttp (=3.8.4) \
    ${PYTHON_PN}-astral (=2.2) \
    ${PYTHON_PN}-async-timeout (=4.0.2) \
    ${PYTHON_PN}-attrs (=22.2.0) \
    ${PYTHON_PN}-atomicwrites-homeassistant (=1.4.1) \
    ${PYTHON_PN}-awesomeversion (=22.9.0) \
    ${PYTHON_PN}-bcrypt (=4.0.1) \   
    ${PYTHON_PN}-certifi (>=2021.5.30) \
    ${PYTHON_PN}-ciso8601 (=2.3.0) \
    ${PYTHON_PN}-httpx (=0.24.0) \
    ${PYTHON_PN}-home-assistant-bluetooth (=1.10.0) \
    ${PYTHON_PN}-ifaddr (>=0.1.7) \
    ${PYTHON_PN}-jinja2 (=3.1.2) \
    ${PYTHON_PN}-lru-dict (=1.1.8) \
    ${PYTHON_PN}-pyjwt (>=2.6.0) \
    ${PYTHON_PN}-cryptography (>=40.0.2) \
    ${PYTHON_PN}-pyopenssl (>=23.1.1) \
    ${PYTHON_PN}-orjson (=3.8.10) \
    ${PYTHON_PN}-pip (>=21.0) \
    ${PYTHON_PN}-python-slugify (=4.0.1) \
    ${PYTHON_PN}-pyyaml (= 6.0) \
    ${PYTHON_PN}-requests (=2.28.2) \
    ${PYTHON_PN}-typing-extensions (=4.5.0) \
    ${PYTHON_PN}-ulid-transform (=0.7.2) \
    ${PYTHON_PN}-voluptuous (=0.13.1) \
    ${PYTHON_PN}-voluptuous-serialize (=2.6.0) \
    ${PYTHON_PN}-yarl (=1.9.2) \
    \
    ${PYTHON_PN}-statistics \
    ${PYTHON_PN}-sqlite3 \
    \
    ${PN}-bluetooth \
    ${PN}-cloud \
    ${PN}-conversation \
    ${PN}-dhcp \
    ${PN}-file-upload \
    ${PN}-frontend \
    ${PN}-hardware \
    ${PN}-google-translate \
    ${PN}-http \
    ${PN}-image-upload \
    ${PN}-mobile-app \
    ${PN}-recorder \
    ${PN}-stream \
    ${PN}-usb \
    ${PN}-zeroconf \
"

RRECOMMENDS:${PN} = "\
    ${PN}-axis \
    ${PN}-backup \
    ${PN}-cast \
    ${PN}-fritz \
    ${PN}-fritzbox \
    ${PN}-ipp \
    ${PN}-met \
    ${PN}-octoprint \
    ${PN}-radio-browser \
    ${PN}-shelly \
    ${PN}-tts \
    ${PN}-upnp \
    ${PN}-ssdp \
    ${PN}-hacs \
"
