# See https://www.home-assistant.io/integrations/#text-to-speech

PACKAGES += "\
    ${PN}-amazon-polly \
    ${PN}-google-translate \
"

ALLOW_EMPTY:${PN}-amazon-polly = "1"
RDEPENDS:${PN}-amazon-polly = "\
    ${PYTHON_PN}-boto3 (>=1.28.17) \
"

ALLOW_EMPTY:${PN}-google-translate = "1"
RDEPENDS:${PN}-google-translate = "\
    ${PYTHON_PN}-gtts (=2.2.4) \
"

RDEPENDS:${PN} += "\
    ${PN}-google-translate \
"

RRECOMMENDS:${PN} += "\
    ${PN}-amazon-polly \
"