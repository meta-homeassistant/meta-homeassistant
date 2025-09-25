SUMMARY = "Bleak backend of ESPHome"
HOMEPAGE = "https://github.com/bluetooth-devices/bleak-esphome"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb4df16459d09819e161c1b17625a532"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c59cf9a9315c66280ea7fb68736b2702074b899d3459ca5dca0aa4acaaf22715"

inherit pypi python_poetry_core cython

PYPI_PACKAGE = "bleak_esphome"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} += " \
    python3-aioesphomeapi (>=30.1.0) \
    python3-bleak (>=1) \
    python3-bluetooth-data-tools (>=1.18.0) \
    python3-habluetooth (>=5.4.0) \
    python3-lru-dict (>=1.2.0) \
    python3-bleak-retry-connector (>=3.8.0) \
"
