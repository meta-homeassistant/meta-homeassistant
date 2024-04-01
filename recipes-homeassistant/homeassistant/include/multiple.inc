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
    python3-axis (=48) \
"

ALLOW_EMPTY:${PN}-cloud = "1"
RDEPENDS:${PN}-cloud = "\
    python3-hass-nabucasa (=0.76.0) \
"

ALLOW_EMPTY:${PN}-fritz = "1"
RDEPENDS:${PN}-fritz = "\
    python3-fritzconnection (=1.13.2) \
    python3-xmltodict (=0.13.0) \
"

ALLOW_EMPTY:${PN}-fritzbox = "1"
RDEPENDS:${PN}-fritzbox = "\
    python3-pyfritzhome (=0.6.10) \
"

ALLOW_EMPTY:${PN}-hue = "1"
RDEPENDS:${PN}-hue = "\
    python3-aiohue (>=4.7.0) \
"

ALLOW_EMPTY:${PN}-matter = "1"
RDEPENDS:${PN}-matter = "\
    python3-python-matter-server (=5.5.0) \
"

ALLOW_EMPTY:${PN}-radio-browser = "1"
RDEPENDS:${PN}-radio-browser = "\
    python3-radios (=0.2.0) \
"

ALLOW_EMPTY:${PN}-shelly = "1"
RDEPENDS:${PN}-shelly = "\
    python3-aioshelly (=8.0.1) \
"

ALLOW_EMPTY:${PN}-tts = "1"
RDEPENDS:${PN}-tts = "\
    python3-mutagen (=1.47.0) \
"

ALLOW_EMPTY:${PN}-upnp = "1"
RDEPENDS:${PN}-upnp = "\
    python3-async-upnp-client (=0.38.1) \
    python3-getmac (=0.9.4) \
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