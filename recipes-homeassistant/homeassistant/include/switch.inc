# See https://www.home-assistant.io/integrations/#switch

PACKAGES += "\
    ${PN}-pulseaudio-loopback \
"

ALLOW_EMPTY:${PN}-pulseaudio-loopback = "1"
RDEPENDS:${PN}-pulseaudio-loopback = "\
    python3-pulsectl (>=23.5.2) \
"

RDEPENDS:${PN} += "\
"

RRECOMMENDS:${PN} += "\
    ${PN}-pulseaudio-loopback \
"