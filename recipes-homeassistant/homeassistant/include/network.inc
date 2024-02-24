# See https://www.home-assistant.io/integrations/#network

PACKAGES += "\
    ${PN}-dhcp \
    ${PN}-route53 \
    ${PN}-ssdp \
    ${PN}-zeroconf \
"

ALLOW_EMPTY:${PN}-dhcp = "1"
RDEPENDS:${PN}-dhcp = "\
    python3-aiodiscover (=1.5.1) \
    python3-scapy (=2.5.0) \
"

ALLOW_EMPTY:${PN}-route53 = "1"
RDEPENDS:${PN}-route53 = "\
    python3-boto3 (>=1.28.17) \
"

ALLOW_EMPTY:${PN}-ssdp = "1"
RDEPENDS:${PN}-ssdp = "\
    python3-async-upnp-client (=0.36.2) \
"

ALLOW_EMPTY:${PN}-zeroconf = "1"
RDEPENDS:${PN}-zeroconf = "\
    python3-zeroconf (>=0.119.0) \
"

RDEPENDS:${PN} += "\
    ${PN}-dhcp \
    ${PN}-zeroconf \
"

RRECOMMENDS:${PN} += "\
    ${PN}-route53 \
    ${PN}-ssdp \
"