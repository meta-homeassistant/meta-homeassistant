SUMMARY = "A python3 library to communicate with Adax"
HOMEPAGE = "https://github.com/Danielhiversen/pyAdaxLocal"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2736a6a8b58491968000c6e0130f0471"

SRC_URI[sha256sum] = "e5cee62e24ae48089a53529a0f8b7cdbb371831c2cef0d2881fff568835c236c"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.0.6) \
    python3-async-timeout (>=1.4.0) \
    python3-bleak \
"

PYPI_PACKAGE = "Adax-local"
