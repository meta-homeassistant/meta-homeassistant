# See https://www.home-assistant.io/integrations/#network

PACKAGES += "\
    ${PN}-dhcp \
    ${PN}-route53 \
    ${PN}-ssdp \
    ${PN}-zeroconf \
"

ALLOW_EMPTY:${PN}-dhcp = "1"
RDEPENDS:${PN}-dhcp = "\
    python3-aiodiscover (=1.6.0) \
    python3-scapy (=2.5.0) \
    python3-cached-ipaddress (=0.3.0) \
"

ALLOW_EMPTY:${PN}-route53 = "1"
RDEPENDS:${PN}-route53 = "\
    python3-boto3 (>=1.33.13) \
"

ALLOW_EMPTY:${PN}-ssdp = "1"
RDEPENDS:${PN}-ssdp = "\
    python3-async-upnp-client (=0.38.1) \
"

ALLOW_EMPTY:${PN}-zeroconf = "1"
RDEPENDS:${PN}-zeroconf = "\
    python3-zeroconf (>=0.131.0) \
"

RDEPENDS:${PN} += "\
    ${PN}-dhcp \
    ${PN}-zeroconf \
"

RRECOMMENDS:${PN} += "\
    ${PN}-route53 \
    ${PN}-ssdp \
"