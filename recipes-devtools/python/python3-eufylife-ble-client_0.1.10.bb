SUMMARY = "A library to communicate with EufyLife Bluetooth devices."
HOMEPAGE = "https://github.com/bdr99/eufylife-ble-client"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=6;endline=6;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "85f52c1627e4c2be6a85833a3ad971a380001aef7aee9fde58247ec81ac2e1e3"

inherit pypi python_poetry_core

PYPI_PACKAGE = "eufylife_ble_client"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-bleak (>=0.19.0) \
    python3-bleak-retry-connector (>=2.3.0) \
    python3-cryptography (>=39.0) \
"
