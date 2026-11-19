SUMMARY = "Minimal pure python memcached client"
HOMEPAGE = "https://github.com/aio-libs/aiomcache/"
LICENSE = "BSD-2-Clause AND BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6fef79088f61f537b76a803b9ffcb726"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/aio-libs/aiomcache.git;protocol=https;branch=master;tag=v${PV}"
SRCREV = "9e93cd5a8dcde40340a6b78a72318f339bd7258c"

inherit setuptools3 ptest-python-pytest

RDEPENDS:${PN}-ptest:append = " \
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-docker \
    python3-python-memcached \
"
