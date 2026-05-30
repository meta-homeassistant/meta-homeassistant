SUMMARY = "A connector for Bleak Clients that handles transient connection failures"
HOMEPAGE = "https://github.com/bluetooth-devices/bleak-retry-connector"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "0645ca814fe9e0f2e0716ffdae5e54de25de75de6197145a1784f20f58e76844"

inherit pypi python_poetry_core

PYPI_PACKAGE = "bleak_retry_connector"

RDEPENDS:${PN} = "\
    python3-bleak (>=0.21.0) \
    python3-dbus-fast (>=1.14.0) \
    python3-bluetooth-adapters (>=0.15.2) \
"
