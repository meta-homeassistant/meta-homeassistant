# See https://www.home-assistant.io/integrations/#history

PACKAGES += "\
    ${PN}-recorder \
"

ALLOW_EMPTY:${PN}-recorder = "1"
RDEPENDS:${PN}-recorder = "\
    ${PYTHON_PN}-fnv-hash-fast (=0.5.0) \
    ${PYTHON_PN}-sqlalchemy (>=2.0.22) \
    ${PYTHON_PN}-psutil-home-assistant (=0.0.1) \
"

RDEPENDS:${PN} += "\
    ${PN}-recorder \
"

RRECOMMENDS:${PN} += "\
"