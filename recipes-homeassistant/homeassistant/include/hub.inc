# See https://www.home-assistant.io/integrations/#hub

PACKAGES += "\
    ${PN}-modbus \
"

ALLOW_EMPTY:${PN}-modbus = "1"
RDEPENDS:${PN}-modbus = "\
    python3-pymodbus (>=3.5.4) \
"

RDEPENDS:${PN} += "\
"

RRECOMMENDS:${PN} += "\
    ${PN}-modbus \
"