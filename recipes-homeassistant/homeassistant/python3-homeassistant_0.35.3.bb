SUMMARY = "Open-source home automation platform running on Python 3"
HOMEPAGE = "https://home-assistant.io/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2aaba14ff23856010e6b6000a4e45fd6"

inherit pypi setuptools3

SRC_URI[md5sum] = "8b81c4be91a28bada412095cf3ca1f66"
SRC_URI[sha256sum] = "e2eb230b6597a17e200e91823f91cf48dcb71da9704b22577334236c31a0558b"

# Home Assistant core
RDEPENDS_${PN} = " \
    python3-requests \
    python3-pyyaml  \
    python3-pytz \
    python3-pip \
    python3-jinja2 \
    python3-voluptuous \
    python3-typing \
    python3-aiohttp \
    python3-async-timeout \
    \
    python3-asyncio \
    python3-multiprocessing \
    python3-sqlite3 \
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

# TODO: Currently broken as it crashes with pthread_cancel error
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
