SUMMARY = "Parser for iBeacon devices"
HOMEPAGE = "https://github.com/bluetooth-devices/ibeacon-ble"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5255d7cd6e5f487c81f17147f84b3ba005d43ca4c103f703f7a7017471a4fe40"

inherit pypi python_poetry_core

PYPI_PACKAGE = "ibeacon_ble"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-aiooui (>=0.1.1) \
    python3-home-assistant-bluetooth (>=1.3.0) \
    python3-mac-vendor-lookup (>=0.1.11) \
"
