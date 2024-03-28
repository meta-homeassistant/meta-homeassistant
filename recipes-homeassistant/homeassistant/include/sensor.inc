# See https://www.home-assistant.io/integrations/#sensor

PACKAGES += "\
    ${PN}-scrape \
"

ALLOW_EMPTY:${PN}-scrape = "1"
RDEPENDS:${PN}-scrape = "\
    python3-beautifulsoup4 (>=4.12.2) \
    python3-lxml (>=4.9.3) \
"

RDEPENDS:${PN} += "\
"

RRECOMMENDS:${PN} += "\
    ${PN}-scrape \
"