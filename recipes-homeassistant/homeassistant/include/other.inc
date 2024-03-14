# See https://www.home-assistant.io/integrations/#other

PACKAGES += "\
    ${PN}-backup \
    ${PN}-frontend \
    ${PN}-hardware \
    ${PN}-http \
    ${PN}-image-upload \
    ${PN}-keyboard-remote \
    ${PN}-mobile-app \
    ${PN}-stream \
"

ALLOW_EMPTY:${PN}-backup = "1"
RDEPENDS:${PN}-backup = "\
    ${PYTHON_PN}-securetar (=2023.3.0) \
"

ALLOW_EMPTY:${PN}-frontend = "1"
RDEPENDS:${PN}-frontend = "\
    ${PYTHON_PN}-home-assistant-frontend (=20231206.0) \
"

ALLOW_EMPTY:${PN}-hardware = "1"
RDEPENDS:${PN}-hardware = "\
    ${PYTHON_PN}-psutil-home-assistant (=0.0.1) \
"

ALLOW_EMPTY:${PN}-http = "1"
RDEPENDS:${PN}-http = "\
    ${PYTHON_PN}-aiohttp-cors (=0.7.0) \
"

ALLOW_EMPTY:${PN}-image-upload = "1"
RDEPENDS:${PN}-image-upload = "\
    ${PYTHON_PN}-pillow (>=10.1.0) \
"

ALLOW_EMPTY:${PN}-keyboard-remote = "1"
RDEPENDS:${PN}-keyboard-remote = "\
    ${PYTHON_PN}-evdev (>=1.6.1) \
    ${PYTHON_PN}-asyncinotify (>=4.0.2) \
"

ALLOW_EMPTY:${PN}-mobile-app = "1"
RDEPENDS:${PN}-mobile-app = "\
    ${PYTHON_PN}-pynacl (=1.5.0) \
"

ALLOW_EMPTY:${PN}-stream = "1"
RDEPENDS:${PN}-stream = "\
    ${PYTHON_PN}-pyturbojpeg (=1.7.1) \
    ${PYTHON_PN}-ha-av (=10.1.1) \
    ${PYTHON_PN}-numpy (>=1.26.0) \
"

RDEPENDS:${PN} += "\
    ${PN}-frontend \
    ${PN}-hardware \
    ${PN}-http \
    ${PN}-image-upload \
    ${PN}-mobile-app \
    ${PN}-stream \
"

RRECOMMENDS:${PN} += "\
    ${PN}-backup \
    ${PN}-keyboard-remote \
"