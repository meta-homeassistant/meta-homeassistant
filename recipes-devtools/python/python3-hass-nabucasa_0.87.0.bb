DESCRIPTION = "Issues related to the cloud integration in Nabu Casa"
HOMEPAGE = "https://github.com/NabuCasa/hass-nabucasa"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit pypi python_setuptools_build_meta

SRC_URI[sha256sum] = "5fa1c174c28436dfdaea3f9e05c138dc9f4d8273fd3da2af6a481791849e4a00"
PYPI_PACKAGE = "hass_nabucasa"

RDEPENDS:${PN} = "\
    python3-acme (=3.0.1) \
    python3-aiohttp (>=3.6.1) \
    ${@bb.utils.contains("DISTRO_FEATURES", "ptest", "python3-atomicwrites", "python3-atomicwrites-homeassistant (=1.4.1)",d)} \
    python3-attrs (>=19.3) \
    python3-ciso8601 (>=2.3.0) \
    python3-core (>=3.11) \
    python3-cryptography (>=42.0.0) \
    python3-ecdsa \
    python3-pycognito (=2024.5.1) \
    python3-pyjwt (>=2.8.0) \
    python3-snitun (>=0.39.1) \
    python3-webrtc-models (<1.0.0) \
    python3-pyasn1 \
"
