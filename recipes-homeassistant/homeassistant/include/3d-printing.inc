# See https://www.home-assistant.io/integrations/#3d-printing

PACKAGES += "\
    ${PN}-octoprint \
"

ALLOW_EMPTY:${PN}-octoprint = "1"
RDEPENDS:${PN}-octoprint = "\
    python3-pyoctoprintapi (=0.1.12) \
"

RDEPENDS:${PN} += "\
"

RRECOMMENDS:${PN} += "\
    ${PN}-octoprint \
"