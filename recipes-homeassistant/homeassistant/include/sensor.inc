# See https://www.home-assistant.io/integrations/#sensor

PACKAGES += "\
    ${PN}-scrape \
"

ALLOW_EMPTY:${PN}-scrape = "1"
RDEPENDS:${PN}-scrape = "\
    ${PYTHON_PN}-beautifulsoup4 (>=4.12.2) \
    ${PYTHON_PN}-lxml (>=4.9.3) \
"

RDEPENDS:${PN} += "\
"

RRECOMMENDS:${PN} += "\
    ${PN}-scrape \
"