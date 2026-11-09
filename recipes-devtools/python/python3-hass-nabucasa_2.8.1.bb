DESCRIPTION = "Issues related to the cloud integration in Nabu Casa"
HOMEPAGE = "https://github.com/NabuCasa/hass-nabucasa"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit python_setuptools_build_meta ptest-python-pytest

SRC_URI = "git://github.com/NabuCasa/hass-nabucasa.git;protocol=https;branch=main;tag=${PV}"
SRCREV = "6243a1771258c4a53d6e16c235f5586dfd970394"

RDEPENDS:${PN} = "\
    python3-acme (>=5.3.1) \
    python3-aiohttp (>=3.6.1) \
    python3-atomicwrites-homeassistant (=1.4.1) \
    python3-attrs (>=19.3) \
    python3-ciso8601 (>=2.3.0) \
    python3-cryptography (>=42.0.0) \
    python3-grpcio (>=1.75.1) \
    python3-icmplib (>=3) \
    python3-josepy (>=2) \
    python3-pycognito (=2024.5.1) \
    python3-pyjwt (>=2.8.0) \
    python3-requests (>=2.0) \
    python3-snitun (>=0.45.1) \
    python3-voluptuous (>=0.15) \
    python3-webrtc-models (<1.0.0) \
    python3-yarl (>=1.20) \
    python3-sentence-stream (>=1.2.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-botocore \
    python3-freezegun \
    python3-pytest-aiohttp \
    python3-pytest-asyncio \
    python3-pytest-socket \
    python3-pytest-timeout \
    python3-syrupy \
    python3-tomli \
    python3-xmltodict \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
    # pytest >= 9.1 shortens long string parameter IDs, which then no longer
    # match the names stored in the snapshot files; keep the old IDs.
    sed -i '/^\[tool\.pytest\.ini_options\]/a parametrize_long_str_id_strategy = "legacy"' \
        ${D}${PTEST_PATH}/pyproject.toml
    # The suite keeps more files open than the default limit of 1024
    # ("Too many open files"); upstream CI runs with a higher limit.
    printf '#!/bin/sh\nulimit -n 65536\npytest --automake\n' > ${D}${PTEST_PATH}/run-ptest
    chmod 0755 ${D}${PTEST_PATH}/run-ptest
}
