SUMMARY = "An async resolver for aiohttp that supports MDNS"
HOMEPAGE = "https://github.com/aio-libs/aiohttp-asyncmdnsresolver"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "aab2cef7ef8ae45b94abf1fc92aa9f4d70cbef7ac0a3d495a86fb96fce357262"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-aiodns (>=3.2.0) \
    python3-aiohttp (>=3.10.0) \
    python3-zeroconf (>=0.124.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
    python3-pytest-cov \
"
