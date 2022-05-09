SUMMARY = "Open-source home automation platform running on Python 3"
HOMEPAGE = "https://home-assistant.io/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"

HOMEASSISTANT_CONFIG_DIR ?= "${localstatedir}/lib/homeassistant"
HOMEASSISTANT_CONFIG_DIR[doc] = "Configuration directory used by home-assistant."
HOMEASSISTANT_USER ?= "homeassistant"
HOMEASSISTANT_USER[doc] = "User the home-assistent service runs as."

inherit python_setuptools_build_meta pypi useradd update-rc.d systemd

SRC_URI[sha256sum] = "d759f9acf87d2f6b0b8598c48700b5c5a6a72ad40cd8248f431266fe9d92e6f2"

SRC_URI += "\
    file://homeassistant.service \
    file://homeassistant.init \
    "

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = "homeassistant"
USERADD_PARAM:${PN} = "--system --home ${HOMEASSISTANT_CONFIG_DIR} \
                       --no-create-home --shell /bin/false \
                       --groups homeassistant,dialout --gid homeassistant ${HOMEASSISTANT_USER}"

INITSCRIPT_NAME = "homeassistant"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "homeassistant.service"

do_install:append () {
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
RDEPENDS:${PN} = " \
    ${PYTHON_PN}-aiohttp (>=3.8.1) \
    ${PYTHON_PN}-astral (>=2.2) \
    ${PYTHON_PN}-async-timeout (>=4.0.2) \
    ${PYTHON_PN}-attrs (>=21.2.0) \
    ${PYTHON_PN}-atomicwrites (>=1.4.0) \
    ${PYTHON_PN}-awesomeversion (>=22.2.0) \
    ${PYTHON_PN}-bcrypt (>=3.1.7) \
    ${PYTHON_PN}-certifi (>=2021.5.30) \
    ${PYTHON_PN}-ciso8601 (>=2.2.0) \
    ${PYTHON_PN}-httpx (>=0.22.0) \
    ${PYTHON_PN}-ifaddr (>=0.1.7) \
    ${PYTHON_PN}-jinja2 (>=3.1.1) \
    ${PYTHON_PN}-pyjwt (>=2.3.0) \
    ${PYTHON_PN}-cryptography (>=36.0.2) \
    ${PYTHON_PN}-python-slugify (>=4.0.1) \
    ${PYTHON_PN}-pyyaml (>= 6.0) \
    ${PYTHON_PN}-requests (>=2.27.1) \
    ${PYTHON_PN}-typing-extensions (>=3.10.0.2) \
    ${PYTHON_PN}-voluptuous (>=0.13.1) \
    ${PYTHON_PN}-voluptuous-serialize (>=2.5.0) \
    ${PYTHON_PN}-yarl (>=1.7.2) \
    \
    ${PYTHON_PN}-pynacl (>=1.5.0) \
    ${PYTHON_PN}-aiodiscover (>=1.4.11) \
    ${PYTHON_PN}-aiohttp-cors (>=0.7.0) \
    ${PYTHON_PN}-async-upnp-client (>=0.29.0) \
    ${PYTHON_PN}-fnvhash (>=0.1.0) \
    ${PYTHON_PN}-hass-nabucasa (>=0.54.0) \
    ${PYTHON_PN}-home-assistant-frontend (>=20220504.1) \
    ${PYTHON_PN}-lru-dict (>=1.1.7) \
    ${PYTHON_PN}-paho-mqtt (>=1.6.1) \
    ${PYTHON_PN}-pillow (>=9.0.1) \
    ${PYTHON_PN}-pip (>=21.0) \
    ${PYTHON_PN}-pyserial (>=3.5)\
    ${PYTHON_PN}-pyudev (>=0.22.0) \
    ${PYTHON_PN}-scapy (>=2.4.5) \
    ${PYTHON_PN}-sqlalchemy (>=1.4.35) \
    ${PYTHON_PN}-zeroconf (>=0.38.4) \
    \
    ${PYTHON_PN}-pycryptodome (>=3.6.6) \
    ${PYTHON_PN}-urllib3 (>=1.26.9) \
    ${PYTHON_PN}-httplib2 (>=0.19.0) \
    ${PYTHON_PN}-grpcio (>=1.45.0) \
    \
    ${PYTHON_PN}-regex (>=2021.8.28) \
    ${PYTHON_PN}-anyio (>=3.5.0) \
    ${PYTHON_PN}-h11 (>=0.12) \
    ${PYTHON_PN}-httpcore (>=0.14.7) \
    ${PYTHON_PN}-hyperframe (>=5.2.0) \
    ${PYTHON_PN}-engineio (>=3.13.1) \
    ${PYTHON_PN}-socketio (>=4.6.0) \
    ${PYTHON_PN}-multidict (>=6.0.2) \
    ${PYTHON_PN}-tzdata \
    \
    ${PYTHON_PN}-frozenlist (>=1.1.1) \
    ${PYTHON_PN}-aiosignal (>=1.1.2) \
    ${PYTHON_PN}-charset-normalizer (>=2.0) \
    ${PYTHON_PN}-pytz \
    ${PYTHON_PN}-six (>=1.4.1) \
    ${PYTHON_PN}-cffi (>=1.1) \
    ${PYTHON_PN}-markupsafe (>=2.0) \
    ${PYTHON_PN}-text-unidecode (>=1.3) \
    ${PYTHON_PN}-idna (>=2.5) \
    ${PYTHON_PN}-pycparser (>= 2.7) \
    \
    ${PYTHON_PN}-aiohue \
    ${PYTHON_PN}-defusedxml (>=0.6.0) \
    ${PYTHON_PN}-distro (>=1.4.0) \
    ${PYTHON_PN}-importlib-metadata (>=1.5.0) \
    ${PYTHON_PN}-mutagen (>=1.44.0) \
    ${PYTHON_PN}-netdisco (>=2.6.0) \
    ${PYTHON_PN}-pymetno (>=0.5.0) \
    ${PYTHON_PN}-pysonos \
    ${PYTHON_PN}-ruamel-yaml (>=0.15.100) \
    ${PYTHON_PN}-samsungctl (>=0.7.1) \
    ${PYTHON_PN}-samsungtvws (>=1.4.0) \
    ${PYTHON_PN}-samsungtv (>=1.0.0) \
    ${PYTHON_PN}-ssdp (>=1.0.1) \
    ${PYTHON_PN}-xmltodict (>=0.12.0) \
    ${PYTHON_PN}-modules \
    ${PYTHON_PN}-coronavirus \
    ${PYTHON_PN}-gtts-token \
    ${PYTHON_PN}-pycognito \
    ${PYTHON_PN}-spotipy \
    ${PYTHON_PN}-systemd \
"
