DESCRIPTION = "Issues related to the cloud integration in Nabu Casa"
HOMEPAGE = "https://github.com/NabuCasa/hass-nabucasa"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "f109ed5a593c47fbcfb547017041d7c5d3db390129fc2640fb13f695280862cd"

RDEPENDS:${PN} = "\
    python3-acme (=2.9.0) \
    python3-aiohttp (>=3.6.1) \
    python3-atomicwrites-homeassistant (=1.4.1) \
    python3-attrs (>=19.3) \
    python3-ciso8601 (>=2.3.0) \
    python3-core (>=3.11) \
    python3-cryptography (>=42.0.0) \
    python3-ecdsa \
    python3-pycognito (=2024.2.0) \
    python3-pyjwt (>=2.8.0) \
    python3-snitun (>=0.36.2) \
"
