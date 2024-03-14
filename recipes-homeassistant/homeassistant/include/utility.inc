# See https://www.home-assistant.io/integrations/#utility

PACKAGES += "\
    ${PN}-bluetooth \
    ${PN}-usb \
"

ALLOW_EMPTY:${PN}-bluetooth = "1"
RDEPENDS:${PN}-bluetooth = "\
    ${PYTHON_PN}-bleak (=0.21.1) \
    ${PYTHON_PN}-bleak-retry-connector (=3.3.0) \
    ${PYTHON_PN}-bluetooth-adapters (=0.16.1) \
    ${PYTHON_PN}-bluetooth-auto-recovery (=1.2.3) \
    ${PYTHON_PN}-bluetooth-data-tools (=1.15.0) \
    ${PYTHON_PN}-dbus-fast (>=2.12.0) \
"

ALLOW_EMPTY:${PN}-usb = "1"
RDEPENDS:${PN}-usb = "\
    ${PYTHON_PN}-pyserial (=3.5) \
    ${PYTHON_PN}-pyudev (>=0.23.2) \
"

RDEPENDS:${PN} += "\
    ${PN}-bluetooth \
    ${PN}-usb \
"

RRECOMMENDS:${PN} += "\
"