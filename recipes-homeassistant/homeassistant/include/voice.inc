# See https://www.home-assistant.io/integrations/#voice

PACKAGES += "\
    ${PN}-assist-pipeline \
    ${PN}-conversation \
"

ALLOW_EMPTY:${PN}-assist-pipeline = "1"
RDEPENDS:${PN}-assist-pipeline = "\
    python3-webrtc-noise-gain (>=1.2.3) \
"

ALLOW_EMPTY:${PN}-conversation = "1"
RDEPENDS:${PN}-conversation = "\
    python3-hassil (>=1.6.1) \
    python3-home-assistant-intents (>=2024.2.28) \
"

RDEPENDS:${PN} += "\
    ${PN}-assist-pipeline \
    ${PN}-conversation \
"

RRECOMMENDS:${PN} += "\
"