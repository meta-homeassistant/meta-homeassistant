SUMMARY = "Bleak backend of ESPHome"
HOMEPAGE = "https://github.com/bluetooth-devices/bleak-esphome"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fb4df16459d09819e161c1b17625a532"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "105159f77269c2731fcf968dc41e3494be8947f5b30a3229dce083db1bb9d37a"

inherit pypi python_poetry_core cython

RDEPENDS:${PN} += "\
    python3-aioesphomeapi (>=45.12.0) \
    python3-bleak (>=3.0.2) \
    python3-bleak-retry-connector (>=4.6.3) \
    python3-bluetooth-data-tools (>=1.18.0) \
    python3-habluetooth (>=6.26.5) \
    python3-lru-dict (>=1.2.0) \
"
