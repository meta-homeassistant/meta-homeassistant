# This file is for any integration which has multiple categories assigned to them.

PACKAGES += "\
    ${PN}-axis \
    ${PN}-cloud \
    ${PN}-fritz \
    ${PN}-fritzbox \
    ${PN}-hue \
    ${PN}-matter \
    ${PN}-radio-browser \
    ${PN}-shelly \
    ${PN}-tts \
    ${PN}-upnp \
"

ALLOW_EMPTY:${PN}-axis = "1"
RDEPENDS:${PN}-axis = "\
    ${PYTHON_PN}-axis (=48) \
"

ALLOW_EMPTY:${PN}-cloud = "1"
RDEPENDS:${PN}-cloud = "\
    ${PYTHON_PN}-hass-nabucasa (=0.74.0) \
"

ALLOW_EMPTY:${PN}-fritz = "1"
RDEPENDS:${PN}-fritz = "\
    ${PYTHON_PN}-fritzconnection (=1.13.2) \
    ${PYTHON_PN}-xmltodict (=0.13.0) \
"

ALLOW_EMPTY:${PN}-fritzbox = "1"
RDEPENDS:${PN}-fritzbox = "\
    ${PYTHON_PN}-pyfritzhome (=0.6.9) \
"

ALLOW_EMPTY:${PN}-hue = "1"
RDEPENDS:${PN}-hue = "\
    ${PYTHON_PN}-aiohue (=4.7.0) \
"

ALLOW_EMPTY:${PN}-matter = "1"
RDEPENDS:${PN}-matter = "\
    ${PYTHON_PN}-matter-server (=5.0.0) \
"

ALLOW_EMPTY:${PN}-radio-browser = "1"
RDEPENDS:${PN}-radio-browser = "\
    ${PYTHON_PN}-radios (=0.2.0) \
"

ALLOW_EMPTY:${PN}-shelly = "1"
RDEPENDS:${PN}-shelly = "\
    ${PYTHON_PN}-aioshelly (=6.1.0) \
"

ALLOW_EMPTY:${PN}-tts = "1"
RDEPENDS:${PN}-tts = "\
    ${PYTHON_PN}-mutagen (=1.47.0) \
"

ALLOW_EMPTY:${PN}-upnp = "1"
RDEPENDS:${PN}-upnp = "\
    ${PYTHON_PN}-async-upnp-client (=0.36.2) \
    ${PYTHON_PN}-getmac (=0.8.2) \
"

RDEPENDS:${PN} += "\
    ${PN}-cloud \
    ${PN}-matter \
    ${PN}-radio-browser \
"

RRECOMMENDS:${PN} += "\
    ${PN}-axis \
    ${PN}-fritz \
    ${PN}-fritzbox \
    ${PN}-hue \
    ${PN}-shelly \
    ${PN}-tts \
    ${PN}-upnp \
"