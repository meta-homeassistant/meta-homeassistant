# See https://www.home-assistant.io/integrations/#history

PACKAGES += "\
    ${PN}-recorder \
"

ALLOW_EMPTY:${PN}-recorder = "1"
RDEPENDS:${PN}-recorder = "\
    python3-sqlite3 \
    python3-fnv-hash-fast (=0.5.0) \
    python3-sqlalchemy (>=2.0.22) \
    python3-psutil-home-assistant (=0.0.1) \
"

RDEPENDS:${PN} += "\
    ${PN}-recorder \
"

RRECOMMENDS:${PN} += "\
"