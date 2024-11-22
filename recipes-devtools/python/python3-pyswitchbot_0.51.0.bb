SUMMARY = "A library to communicate with Switchbot"
HOMEPAGE = "https://github.com/Danielhiversen/pySwitchbot/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5d503272f52c35147ec960cb56a03bf4"

SRC_URI[sha256sum] = "2311691933ad2a2af958721736716b54c7dde642c7f8b035eab808ff0a0a4a3b"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.9.5)  \
    python3-bleak (>=0.19.0) \
    python3-bleak-retry-connector (>=3.4.0) \
    python3-cryptography (>=39.0.0) \
    python3-pyopenssl (>=23.0.0) \
"
