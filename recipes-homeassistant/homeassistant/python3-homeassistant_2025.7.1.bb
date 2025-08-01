SUMMARY = "Open-source home automation platform running on Python 3"
HOMEPAGE = "https://home-assistant.io/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"

HOMEASSISTANT_CONFIG_DIR ?= "${localstatedir}/lib/homeassistant"
HOMEASSISTANT_CONFIG_DIR[doc] = "Configuration directory used by home-assistant."
HOMEASSISTANT_USER ?= "homeassistant"
HOMEASSISTANT_USER[doc] = "User the home-assistent service runs as."

SRC_URI = "git://github.com/home-assistant/core.git;protocol=https;branch=master \
           file://homeassistant.service \
           file://run-ptest-sample \
           file://0001-Relax-setuptools.patch \
           "
SRC_URI[sha256sum] = "f4181f4023feb78cef0be655234200966daa140aea4634dbf3def8b18fd21d48"
SRCREV = "5d6b02f470b9ba46a02b7f40a4304f666727f909"

inherit python_setuptools_build_meta useradd systemd ptest-python-pytest

USERADD_PACKAGES = "${PN}"
GROUPADD_PARAM:${PN} = "homeassistant"
USERADD_PARAM:${PN} = "\
    --system --home ${HOMEASSISTANT_CONFIG_DIR} \
    --no-create-home --shell /bin/false \
    --groups homeassistant,dialout --gid homeassistant ${HOMEASSISTANT_USER} \
"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE:${PN} = "homeassistant.service"

do_configure:append() {
    # On startup the first boot will always fail and an error is thrown that translations are not found.
    # This is apparently the answer: https://community.home-assistant.io/t/new-install-onboarding-failedkeyerror-component-onboarding-area-living-room/689712/6
    nativepython3 -m script.translations develop --all
    # Due to running this several build files are created and they should be cleaned to avoid polluting the image with unnecessary files
    rm -rf ${S}/script/__pycache__
    rm -rf ${S}/script/translations/__pycache__
}

do_install:append () {
    install -d -o ${HOMEASSISTANT_USER} -g homeassistant ${D}${HOMEASSISTANT_CONFIG_DIR}

    # Install systemd unit files and set correct config directory
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${UNPACKDIR}/homeassistant.service ${D}${systemd_unitdir}/system
    sed -i -e 's,@HOMEASSISTANT_CONFIG_DIR@,${HOMEASSISTANT_CONFIG_DIR},g' ${D}${systemd_unitdir}/system/homeassistant.service
    sed -i -e 's,@HOMEASSISTANT_USER@,${HOMEASSISTANT_USER},g' ${D}${systemd_unitdir}/system/homeassistant.service
}

# Home Assistant core
# Home Assistant contains thousands of integrations.
# at https://www.home-assistant.io/integrations/
require recipes-homeassistant/homeassistant/python3-homeassistant/integrations.inc
require recipes-homeassistant/homeassistant/python3-homeassistant/integrations-tests.inc

#TODO: python3-uv (=0.7.1)
#TODO: python3-aiohttp (=3.12.6)
RDEPENDS:${PN} += "\
    python3-aiodns (>=3.5.0) \
    python3-aiohasupervisor (=0.3.1) \
    python3-aiohttp (>=3.11.8) \
    python3-aiohttp-cors (=0.8.1) \
    python3-aiohttp-fast-zlib (=0.3.0) \
    python3-aiohttp-asyncmdnsresolver (=0.1.1) \
    python3-aiozoneinfo (=0.2.3) \
    python3-annotatedyaml (=0.4.5) \
    python3-astral (=2.2) \
    python3-async-interrupt (=1.2.2) \
    python3-attrs (>=25.3.0) \
    ${@bb.utils.contains("DISTRO_FEATURES", "ptest", "python3-atomicwrites", "python3-atomicwrites-homeassistant (=1.4.1)",d)} \
    python3-audioop-lts (=0.2.1) \
    python3-awesomeversion (>=25.5.0) \
    python3-bcrypt (>=4.3.0) \
    python3-certifi (>=2021.5.30) \
    python3-ciso8601 (=2.3.2) \
    python3-cronsim (>=2.6) \
    python3-fnv-hash-fast (>=1.5.0) \
    python3-hass-nabucasa (>=0.105.0) \
    python3-httpx (>=0.28.1) \
    python3-home-assistant-bluetooth (>=1.13.1) \
    python3-ifaddr (=0.2.0) \
    python3-jinja2 (>=3.1.6) \
    python3-lru-dict (>=1.3.0) \
    python3-mutagen (>=1.47.0) \
    python3-pyjwt (=2.10.1) \
    python3-cryptography (>=45.0.3) \
    python3-pillow (>=11.2.1) \
    python3-propcache (>=0.3.2) \
    python3-pyopenssl (>=25.1.0) \
    python3-orjson (>=3.10.18) \
    python3-packaging (>=23.1) \
    python3-psutil-home-assistant (=0.0.1) \
    python3-python-slugify (=8.0.4) \
    python3-pyyaml (>=6.0.2) \
    python3-requests (>=2.32.4) \
    python3-securetar (=2025.2.1) \
    python3-sqlalchemy (>=2.0.41) \
    python3-standard-aifc (=3.13.0) \
    python3-standard-telnetlib (=3.13.0) \
    python3-typing-extensions (>=4.14.0) \
    python3-ulid-transform (>=1.4.0) \
    python3-urllib3 (>=2.0) \
    python3-voluptuous (=0.15.2) \
    python3-voluptuous-serialize (=2.6.0) \
    python3-voluptuous-openapi (=0.1.0) \
    python3-yarl (>=1.20.1) \
    python3-webrtc-models (>=0.3.0) \
    python3-zeroconf (>=0.147.0) \
    \
    python3-statistics \
    python3-core (>=3.13.0) \
"

#TODO: python3-pydantic (=2.11.7)
RDEPENDS:${PN}-ptest = "\
    python3-astroid (>=3.3.10) \
    python3-coverage (>=7.8.2) \
    python3-freezegun (>=1.5.2) \
    python3-go2rtc-client (>=0.2.1) \
    python3-license-expression (>=30.4.1) \
    python3-mock-open (>=1.4.0) \
    python3-pydantic \
    python3-pylint (>=3.3.7) \
    python3-pytest-aiohttp (>=1.1.0) \
    python3-pytest-asyncio (>=1.0.0) \
    python3-pytest-cov (>=6.1.1) \
    python3-pytest-freezer (>=0.4.9) \
    python3-pytest-socket (>=0.7.0) \
    python3-pytest-sugar (>=1.0.0) \
    python3-pytest-timeout (>=2.4.0) \
    python3-pytest-unordered (>=0.7.0) \
    python3-pytest-xdist (>=3.7.0) \
    python3-requests-mock (>=1.12.1) \
    python3-respx (>=0.22.0) \
    python3-syrupy (>=4.9.1) \
    python3-tqdm (>=4.67.1) \
    \
    bash \
    tzdata \
"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    install -d ${D}${PTEST_PATH}/script
    install -d ${D}${PTEST_PATH}/pylint
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
    cp -rf ${S}/script/* ${D}${PTEST_PATH}/script/
    cp -rf ${S}/pylint/* ${D}${PTEST_PATH}/pylint/
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
}
