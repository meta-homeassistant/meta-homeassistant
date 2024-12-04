SUMMARY = "A library to communicate with Switchbot"
HOMEPAGE = "https://github.com/Danielhiversen/pySwitchbot/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5d503272f52c35147ec960cb56a03bf4"

SRC_URI[sha256sum] = "c0317c3e87bca6d6a11edd43a348ad8f79fd38e3ef93196ad403a00d36911e77"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.9.5)  \
    python3-bleak (>=0.19.0) \
    python3-bleak-retry-connector (>=3.4.0) \
    python3-cryptography (>=39.0.0) \
    python3-pyopenssl (>=23.0.0) \
"
