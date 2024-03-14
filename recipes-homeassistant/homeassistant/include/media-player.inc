# See https://www.home-assistant.io/integrations/#media-player

PACKAGES += "\
    ${PN}-cast \
    ${PN}-vlc \
"

ALLOW_EMPTY:${PN}-cast = "1"
RDEPENDS:${PN}-cast = "\
    ${PYTHON_PN}-pychromecast (>=13.0.8) \
"

ALLOW_EMPTY:${PN}-vlc = "1"
RDEPENDS:${PN}-vlc = "\
    ${PYTHON_PN}-python-vlc (>=3.0.18122) \
"

RDEPENDS:${PN} += "\
"

RRECOMMENDS:${PN} += "\
    ${PN}-cast \
    ${PN}-vlc \
"