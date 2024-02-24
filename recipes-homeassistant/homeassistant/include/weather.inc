# See https://www.home-assistant.io/integrations/#weather

PACKAGES += "\
    ${PN}-met \
"

ALLOW_EMPTY:${PN}-met = "1"
RDEPENDS:${PN}-met = "\
    python3-pymetno (>=0.11.0) \
"

RDEPENDS:${PN} += "\
"

RRECOMMENDS:${PN} += "\
    ${PN}-met \
"