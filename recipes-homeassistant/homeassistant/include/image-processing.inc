# See https://www.home-assistant.io/integrations/#image-processing

PACKAGES += "\
    ${PN}-ffmpeg \
"

ALLOW_EMPTY:${PN}-ffmpeg = "1"
RDEPENDS:${PN}-ffmpeg = "\
    python3-ha-ffmpeg (=3.2.0) \
"

RDEPENDS:${PN} += "\
    ${PN}-ffmpeg \
"

RRECOMMENDS:${PN} += "\
"