SUMMARY = "A library to communicate with Switchbot"
HOMEPAGE = "https://github.com/Danielhiversen/pySwitchbot/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5d503272f52c35147ec960cb56a03bf4"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "fa7cedcc9c0fdef8e0f96ae9db2dd30cdd829477e97e99f2b3dfa347ce3861bf"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.9.5)  \
    python3-bleak (>=0.19.0) \
    python3-bleak-retry-connector (>=3.4.0) \
    python3-cryptography (>=39.0.0) \
    python3-pyopenssl (>=23.0.0) \
"
