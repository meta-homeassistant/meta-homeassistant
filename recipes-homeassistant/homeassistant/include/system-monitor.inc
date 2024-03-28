# See https://www.home-assistant.io/integrations/#system-monitor

PACKAGES += "\
    ${PN}-ipp \
    ${PN}-sentry \
    ${PN}-systemmonitor \
"

ALLOW_EMPTY:${PN}-ipp = "1"
RDEPENDS:${PN}-ipp = "\
    python3-pyipp (=0.14.4) \
"

ALLOW_EMPTY:${PN}-sentry = "1"
RDEPENDS:${PN}-sentry = "\
    python3-sentry-sdk (>=1.37.1) \
"

ALLOW_EMPTY:${PN}-systemmonitor = "1"
RDEPENDS:${PN}-systemmonitor = "\
    python3-psutil (>=5.9.7) \
"

RDEPENDS:${PN} += "\
"

RRECOMMENDS:${PN} += "\
    ${PN}-ipp \
    ${PN}-sentry \
    ${PN}-systemmonitor \
"