# See https://www.home-assistant.io/integrations/#system-monitor

PACKAGES += "\
    ${PN}-ipp \
    ${PN}-sentry \
    ${PN}-systemmonitor \
"

ALLOW_EMPTY:${PN}-ipp = "1"
RDEPENDS:${PN}-ipp = "\
    ${PYTHON_PN}-pyipp (=0.14.4) \
"

ALLOW_EMPTY:${PN}-sentry = "1"
RDEPENDS:${PN}-sentry = "\
    ${PYTHON_PN}-sentry-sdk (>=1.31.0) \
"

ALLOW_EMPTY:${PN}-systemmonitor = "1"
RDEPENDS:${PN}-systemmonitor = "\
    ${PYTHON_PN}-psutil (>=5.9.6) \
"

RDEPENDS:${PN} += "\
"

RRECOMMENDS:${PN} += "\
    ${PN}-ipp \
    ${PN}-sentry \
    ${PN}-systemmonitor \
"