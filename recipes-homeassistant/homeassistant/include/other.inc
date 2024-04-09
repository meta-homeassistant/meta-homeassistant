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
    python3-securetar (=2024.2.1) \
"

ALLOW_EMPTY:${PN}-frontend = "1"
RDEPENDS:${PN}-frontend = "\
    python3-home-assistant-frontend (=20240307.0) \
"

ALLOW_EMPTY:${PN}-hardware = "1"
RDEPENDS:${PN}-hardware = "\
    python3-psutil-home-assistant (=0.0.1) \
"

ALLOW_EMPTY:${PN}-http = "1"
RDEPENDS:${PN}-http = "\
    python3-aiohttp-cors (=0.7.0) \
    python3-aiohttp-fast-url-dispatcher (=0.3.0) \
    python3-aiohttp-zlib-ng (=0.3.1) \
"

ALLOW_EMPTY:${PN}-image-upload = "1"
RDEPENDS:${PN}-image-upload = "\
    python3-pillow (>=10.2.0) \
"

ALLOW_EMPTY:${PN}-keyboard-remote = "1"
RDEPENDS:${PN}-keyboard-remote = "\
    python3-evdev (>=1.6.1) \
    python3-asyncinotify (>=4.0.2) \
"

ALLOW_EMPTY:${PN}-mobile-app = "1"
RDEPENDS:${PN}-mobile-app = "\
    python3-pynacl (=1.5.0) \
"

ALLOW_EMPTY:${PN}-stream = "1"
RDEPENDS:${PN}-stream = "\
    python3-pyturbojpeg (=1.7.1) \
    python3-ha-av (=10.1.1) \
    python3-numpy (>=1.26.0) \
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