SUMMARY = "A connector for Bleak Clients that handles transient connection failures"
HOMEPAGE = "https://github.com/bluetooth-devices/bleak-retry-connector"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"

SRC_URI[sha256sum] = "56a53fd49a0d4cd1a467d07677f4f7741b1fe03ce9c781585b595e2c1b2230df"

PYPI_PACKAGE = "bleak_retry_connector"

inherit pypi python_setuptools_build_meta python_poetry_core

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
    python3-async-timeout (>=4.0.1) \
    python3-bleak (>=0.21.0) \
    python3-bluetooth-adapters (>=0.15.2) \
    python3-dbus-fast (>=1.14.0) \
"
