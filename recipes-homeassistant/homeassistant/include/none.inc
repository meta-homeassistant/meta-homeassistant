# This is for the integrations which have no assigned category on https://www.home-assistant.io/integrations/

PACKAGES += "\
    ${PN}-file-upload \
"

ALLOW_EMPTY:${PN}-file-upload = "1"
RDEPENDS:${PN}-file-upload = "\
    ${PYTHON_PN}-janus (=1.0.0) \
"

RDEPENDS:${PN} += "\
    ${PN}-file-upload \
"

RRECOMMENDS:${PN} += "\
"