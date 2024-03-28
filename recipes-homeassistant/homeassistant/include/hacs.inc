# See https://hacs.xyz/

PACKAGES += "\
    ${PN}-hacs \
"

ALLOW_EMPTY:${PN}-hacs = "1"
RDEPENDS:${PN}-hacs = "\
    python3-aiogithubapi (=22.10.1) \
"

RDEPENDS:${PN} += "\
"

RRECOMMENDS:${PN} += "\
    ${PN}-hacs \
"