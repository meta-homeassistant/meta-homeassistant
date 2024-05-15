SUMMARY = "sessions for aiohttp.web"
HOMEPAGE = "https://github.com/aio-libs/aiohttp_session/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9eaa7e596ac33f220516bc368102250e"

SRC_URI:append = " \
    file://run-ptest \
"
SRC_URI[sha256sum] = "0ccd11a7c77cb9e5a61f4daacdc9170d561112f9cfaf9e9a2d9867c0587d1950"

inherit pypi setuptools3

PACKAGES += "\
    ${PN}-python-version-smaller-3-dot-8 \
    ${PN}-aioredis \
    ${PN}-aiomcache \
    ${PN}-pycrypto \
    ${PN}-secure \
    ${PN}-pynacl \
"

# Uncomment this line to enable all the optional features.
#PACKAGECONFIG ?= "python-version-smaller-3-dot-8 aiomcache aioredis pycrypto pynacl secure"
PACKAGECONFIG[python-version-smaller-3-dot-8] = ",,,python3-typing_extensions"
PACKAGECONFIG[aiomcache] = ",,,python3-aiomcache"
PACKAGECONFIG[aioredis] = ",,,python3-redis"
PACKAGECONFIG[pycrypto] = ",,,python3-cryptography"
PACKAGECONFIG[pynacl] = ",,,python3-pynacl"
PACKAGECONFIG[secure] = ",,,python3-cryptography"

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.8) \
"

RDEPENDS:${PN}-python-version-smaller-3-dot-8 = "python3-typing-extensions"
RDEPENDS:${PN}-aioredis = "python3-redis"
RDEPENDS:${PN}-aiomcache = "python3-aiomcache"
RDEPENDS:${PN}-pycrypto = "python3-cryptography"
RDEPENDS:${PN}-secure = "python3-cryptography"
RDEPENDS:${PN}-pynacl = "python3-pynacl"

PYPI_PACKAGE = "aiohttp-session"
