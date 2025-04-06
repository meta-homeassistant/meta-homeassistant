SUMMARY = "A connector for Bleak Clients that handles transient connection failures"
HOMEPAGE = "https://github.com/bluetooth-devices/bleak-retry-connector"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5c772298b86bcd3b46a57b16cdd9aa5fca9434ebcf87d72493af94e4f4ca2a6e"

inherit pypi python_poetry_core

PYPI_PACKAGE = "bleak_retry_connector"

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
"

RDEPENDS:${PN}-dev += "\
    python3-bleak (>=0.21.0) \
    python3-bluetooth-adapters (>=0.15.2) \
    python3-dbus-fast (>=1.14.0) \
"
