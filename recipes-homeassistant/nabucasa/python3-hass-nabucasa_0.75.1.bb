DESCRIPTION = "Issues related to the cloud integration in Nabu Casa"
HOMEPAGE = "https://github.com/NabuCasa/hass-nabucasa"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit pypi setuptools3

SRC_URI[sha256sum] = "c3ee856a81301c38016e6b2a5ae36fa633975df53e6163b278696284d00a3647"

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
    python3-pycognito (=2023.5.0) \
    python3-snitun (>=0.36.2) \
    python3-ciso8601 (>=2.3.0) \
    python3-acme (=2.7.4) \
    python3-cryptography (>=2.8) \
    python3-attrs (>=19.3) \
    python3-aiohttp (>=3.6.1) \
    python3-atomicwrites-homeassistant (=1.4.1) \ 
"
