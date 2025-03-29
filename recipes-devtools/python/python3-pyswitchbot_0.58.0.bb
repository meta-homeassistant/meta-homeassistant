SUMMARY = "A library to communicate with Switchbot"
HOMEPAGE = "https://github.com/Danielhiversen/pySwitchbot/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5d503272f52c35147ec960cb56a03bf4"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "8f8453bed03e4de791518840369db247e60122d5102b7a2ee4c701e46feba7e4"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.9.5)  \
    python3-bleak (>=0.19.0) \
    python3-bleak-retry-connector (>=3.4.0) \
    python3-cryptography (>=39.0.0) \
    python3-pyopenssl (>=23.0.0) \
"
