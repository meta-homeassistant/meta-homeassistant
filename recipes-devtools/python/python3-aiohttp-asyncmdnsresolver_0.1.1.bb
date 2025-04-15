SUMMARY = "An async resolver for aiohttp that supports MDNS"
HOMEPAGE = "https://github.com/aio-libs/aiohttp-asyncmdnsresolver"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[sha256sum] = "8c65d4b08b42c8a260717a2766bd5967a1d437cee852a9b21f3928b5171a7c81"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "aiohttp_asyncmdnsresolver"
RDEPENDS:${PN} = "\
    python3-aiodns (>=3.2.0) \
    python3-aiohttp (>=3.10.0) \
    python3-zeroconf (>=0.124.0) \
"
