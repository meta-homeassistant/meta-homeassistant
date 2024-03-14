# See https://www.home-assistant.io/integrations/#voice

PACKAGES += "\
    ${PN}-assist-pipeline \
    ${PN}-conversation \
"

ALLOW_EMPTY:${PN}-assist-pipeline = "1"
RDEPENDS:${PN}-assist-pipeline = "\
    ${PYTHON_PN}-webrtc-noise-gain (>=1.2.3) \
"

ALLOW_EMPTY:${PN}-conversation = "1"
RDEPENDS:${PN}-conversation = "\
    ${PYTHON_PN}-hassil (>=1.2.5) \
    ${PYTHON_PN}-home-assistant-intents (>=2023.12.5) \
"

RDEPENDS:${PN} += "\
    ${PN}-assist-pipeline \
    ${PN}-conversation \
"

RRECOMMENDS:${PN} += "\
"