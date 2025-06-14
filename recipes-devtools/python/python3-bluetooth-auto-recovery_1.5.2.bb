SUMMARY = "Recover bluetooth adapters that are in an stuck state"
HOMEPAGE = "https://github.com/bluetooth-devices/bluetooth-auto-recovery"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d8b5b84f8af09011094cd7c29a9f972c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "\
    git://github.com/Bluetooth-Devices/bluetooth-auto-recovery.git;protocol=https;branch=main \
"
SRC_URI[sha256sum] = "8bac63dda39a8dfd7164af88d43c1ef27661108ec182a9327677b76e3222698d"
SRCREV = "6c3b8541e3f1507dd3e54a4d426d88e3a29f0955"

inherit python_poetry_core ptest-python-pytest

S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-core (>3.9) \
    python3-pyric (>=0.1.6.3) \
    python3-btsocket (>=0.2.0) \
    python3-async-timeout (>=4.0.1) \
    python3-bluetooth-adapters (>=0.16.0) \
    python3-usb-devices (>=0.4.1) \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
"
