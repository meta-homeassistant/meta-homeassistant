# See https://www.home-assistant.io/integrations/#utility

PACKAGES += "\
    ${PN}-bluetooth \
    ${PN}-usb \
"

ALLOW_EMPTY:${PN}-bluetooth = "1"
RDEPENDS:${PN}-bluetooth = "\
    python3-bleak (=0.21.1) \
    python3-bleak-retry-connector (=3.5.0) \
    python3-bluetooth-adapters (=0.19.1) \
    python3-bluetooth-auto-recovery (=1.4.2) \
    python3-bluetooth-data-tools (=1.19.0) \
    python3-dbus-fast (>=2.21.1) \
    python3-habluetooth (=2.8.0) \
"

ALLOW_EMPTY:${PN}-usb = "1"
RDEPENDS:${PN}-usb = "\
    python3-pyserial (=3.5) \
    python3-pyudev (>=0.23.2) \
"

RDEPENDS:${PN} += "\
    ${PN}-bluetooth \
    ${PN}-usb \
"

RRECOMMENDS:${PN} += "\
"