# See https://www.home-assistant.io/integrations/#image-processing

PACKAGES += "\
    ${PN}-ffmpeg \
"

ALLOW_EMPTY:${PN}-ffmpeg = "1"
RDEPENDS:${PN}-ffmpeg = "\
    ${PYTHON_PN}-ha-ffmpeg (=3.1.0) \
"

RDEPENDS:${PN} += "\
    ${PN}-ffmpeg \
"

RRECOMMENDS:${PN} += "\
"