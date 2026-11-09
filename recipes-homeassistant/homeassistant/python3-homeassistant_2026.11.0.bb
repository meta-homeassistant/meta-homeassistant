SUMMARY = "Open-source home automation platform running on Python 3"
HOMEPAGE = "https://home-assistant.io/"
SECTION = "devel/python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

HOMEASSISTANT_CONFIG_DIR ?= "${localstatedir}/lib/homeassistant"
HOMEASSISTANT_CONFIG_DIR[doc] = "Configuration directory used by home-assistant."
HOMEASSISTANT_USER ?= "homeassistant"
HOMEASSISTANT_USER[doc] = "User the home-assistent service runs as."
HOMEASSISTANT_VENV ?= "${libdir}/homeassistant/venv"
HOMEASSISTANT_VENV[doc] = "Virtual environment, on top of the system packages, that the home-assistant service runs in."

SRC_URI = "git://github.com/home-assistant/core.git;protocol=https;branch=master \
           file://homeassistant.service \
           file://run-ptest-sample \
           file://0001-Relax-setuptools.patch \
           file://0002-skip-unsupported-installation-method-test.patch \
           file://0003-repair-test_set_scan_interval_via_config.patch \
           file://0005-Stabilize-corrupt-storage-JSON-assertion.patch \
           file://0001-disable-flaky-test.patch \
           "
SRCREV = "74cf5a49c63ed8d4d87717844bf14f79c28c9cea"

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

FILES:${PN} += "${HOMEASSISTANT_VENV}"

# script.translations (run below) imports orjson since 2026.11
DEPENDS += "python3-orjson-native"

do_configure:append() {
    # On startup the first boot will always fail and an error is thrown that translations are not found.
    # This is apparently the answer: https://community.home-assistant.io/t/new-install-onboarding-failedkeyerror-component-onboarding-area-living-room/689712/6
    nativepython3 -m script.translations develop --all
    # Due to running this several build files are created and they should be cleaned to avoid polluting the image with unnecessary files
    # (the translations script imports script.hassfest and packages/hassfest too)
    find ${S}/script ${S}/packages -name __pycache__ -type d -prune -exec rm -rf {} +
}

do_install:append () {
    install -d -o ${HOMEASSISTANT_USER} -g homeassistant ${D}${HOMEASSISTANT_CONFIG_DIR}

    # Install systemd unit files and set correct config directory
    install -d ${D}${systemd_unitdir}/system
    install -m 0644 ${UNPACKDIR}/homeassistant.service ${D}${systemd_unitdir}/system
    sed -i -e 's,@HOMEASSISTANT_CONFIG_DIR@,${HOMEASSISTANT_CONFIG_DIR},g' ${D}${systemd_unitdir}/system/homeassistant.service
    sed -i -e 's,@HOMEASSISTANT_USER@,${HOMEASSISTANT_USER},g' ${D}${systemd_unitdir}/system/homeassistant.service
    sed -i -e 's,@HOMEASSISTANT_VENV@,${HOMEASSISTANT_VENV},g' ${D}${systemd_unitdir}/system/homeassistant.service

    # Since 2026.11 Home Assistant refuses to start unless it runs in a
    # virtual environment or a container. Provide a venv that uses the
    # system interpreter and the packages installed by the image
    # (include-system-site-packages), so nothing is installed twice.
    install -d ${D}${HOMEASSISTANT_VENV}/bin
    ln -s ${bindir}/python3 ${D}${HOMEASSISTANT_VENV}/bin/python3
    printf 'home = %s\ninclude-system-site-packages = true\nversion = %s\n' \
        ${bindir} ${PYTHON_BASEVERSION} > ${D}${HOMEASSISTANT_VENV}/pyvenv.cfg
}

# Home Assistant core
# Home Assistant contains thousands of integrations.
# at https://www.home-assistant.io/integrations/
require ${THISDIR}/python3-homeassistant/integrations.inc
require ${THISDIR}/python3-homeassistant/integrations-tests.inc
RDEPENDS:${PN} += "\
    python3-aiodns (>=4.0.4) \
    python3-aiogithubapi (>=26.0.0) \
    python3-aiohttp (>=3.14.5) \
    python3-aiohttp-asyncmdnsresolver (>=0.2.0) \
    python3-aiohttp-cors (>=0.8.1) \
    python3-aiohttp-fast-zlib (>=0.3.0) \
    python3-aiozoneinfo (>=0.2.3) \
    python3-annotatedyaml (>=1.0.2) \
    python3-astral (>=2.2) \
    python3-async-interrupt (>=1.2.2) \
    python3-atomicwrites-homeassistant (>=1.4.1) \
    python3-attrs (>=26.1.0) \
    python3-audioop-lts (>=0.2.2) \
    python3-awesomeversion (>=25.8.0) \
    python3-bcrypt (>=5.0.0) \
    python3-certifi (>=2021.5.30) \
    python3-ciso8601 (>=2.3.3) \
    python3-core (>=3.14.2) \
    python3-cronsim (>=2.7) \
    python3-cryptography (>=50.0.2) \
    python3-fnv-hash-fast (>=2.0.3) \
    python3-hass-nabucasa (>=2.8.1) \
    python3-home-assistant-bluetooth (>=2.0.0) \
    python3-httpx2 (>=2.14.0) \
    python3-ifaddr (>=0.2.0) \
    python3-jinja2 (>=3.1.6) \
    python3-lru-dict (>=1.4.1) \
    python3-orjson (>=3.13.0) \
    python3-packaging (>=23.1) \
    python3-pillow (>=13.0.0) \
    python3-probatio (>=0.13.0) \
    python3-propcache (>=0.5.4) \
    python3-psutil-home-assistant (>=0.0.1) \
    python3-pyjwt (>=2.15.1) \
    python3-pyopenssl (>=26.4.0) \
    python3-pyserial (>=3.5) \
    python3-python-slugify (>=9.1.3) \
    python3-pyyaml (>=6.0.3) \
    python3-requests (>=2.34.2) \
    python3-securetar (>=2026.10.0) \
    python3-sqlalchemy (>=2.0.54) \
    python3-standard-aifc (>=3.13.0) \
    python3-standard-telnetlib (>=3.13.0) \
    python3-statistics \
    python3-truststore (>=0.10.4) \
    python3-typing-extensions (>=4.16.0) \
    python3-ulid-transform (>=2.2.9) \
    python3-urllib3 (>=2.0) \
    python3-uv (>=0.13.6) \
    python3-webrtc-models (>=0.3.0) \
    python3-yarl (>=1.25.1) \
    python3-zeroconf (>=0.152.0) \
"

RDEPENDS:${PN}-ptest = "\
    python3-ast-serialize (>=0.12.1) \
    python3-astroid (>=4.3.4) \
    python3-coverage (>=7.16.2) \
    python3-freezegun (>=1.5.5) \
    python3-go2rtc-client \
    python3-license-expression (>=30.4.4) \
    python3-mock-open (>=1.4.0) \
    python3-pydantic (>=2.14.1) \
    python3-pygithub (>=2.10.0) \
    python3-pylint (>=4.1.3) \
    python3-pylint-per-file-ignores (>=4.0.0) \
    python3-pytest-aiohttp (>=1.1.1) \
    python3-pytest-asyncio (>=1.4.0) \
    python3-pytest-codspeed (>=5.0.3) \
    python3-pytest-cov (>=7.1.0) \
    python3-pytest-freezer (>=0.4.9) \
    python3-pytest-picked (>=0.5.1) \
    python3-pytest-socket (>=0.8.1) \
    python3-pytest-sugar (>=1.1.1) \
    python3-pytest-timeout (>=2.4.0) \
    python3-pytest-unordered (>=0.8.0) \
    python3-pytest-xdist (>=3.8.0) \
    python3-requests (>=2.34.2) \
    python3-requests-mock (>=1.12.1) \
    python3-respx (>=0.23.1) \
    python3-syrupy (>=6.1.1) \
    python3-tqdm (>=4.70.1) \
    python3-unidiff (>=1.0.1) \
    ${PN} \
    bash \
    tzdata \
    ${@bb.utils.contains('PACKAGECONFIG', 'integration-tests', 'python3-pytest-rerunfailures', '', d)} \
"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    install -d ${D}${PTEST_PATH}/script
    install -d ${D}${PTEST_PATH}/packages
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
    cp -rf ${S}/script/* ${D}${PTEST_PATH}/script/
    cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
    # pyproject.toml puts packages/pylint-home-assistant on pythonpath
    cp -rf ${S}/packages/pylint-home-assistant ${D}${PTEST_PATH}/packages/
    # Upstream installs the test helpers and hassfest as editable packages.
    # Ship them next to the tests instead; run-ptest loads the pytest plugin
    # with -p, as its pytest11 entry point only exists for an installed
    # distribution.
    cp -rf ${S}/packages/pytest-homeassistant/pytest_homeassistant ${D}${PTEST_PATH}/
    cp -rf ${S}/packages/hassfest/hassfest ${D}${PTEST_PATH}/
    # Core pins pytest 9.0; pytest >= 9.1 shortens long string parameter
    # IDs, which then no longer match the names in the snapshot files.
    sed -i '/^\[tool\.pytest\.ini_options\]/a parametrize_long_str_id_strategy = "legacy"' \
        ${D}${PTEST_PATH}/pyproject.toml
    # Run the tests with the interpreter of the service's venv, as
    # homeassistant.__main__ refuses to start outside one.
    sed -i -e 's,@HOMEASSISTANT_VENV@,${HOMEASSISTANT_VENV},g' ${D}${PTEST_PATH}/run-ptest
}
