SUMMARY = "Discover hosts by arp and ptr lookup"
HOMEPAGE = "https://github.com/bdraco/aiodiscover"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bb5cee7a63edfb80ada99f0db1e4ed62"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "\
    git://github.com/bdraco/aiodiscover.git;protocol=https;branch=main \
"
SRC_URI[sha256sum] = "73846ff8b85abaffaaa0ad4fad5965b76c7d518878ecdd0e5dcf1126d77a57c7"
SRCREV = "60b1fc561e101d4c85f7d5b577c6af021ea6ed5d"

inherit  python_poetry_core ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-async-timeout (>=4.0.1) \
    python3-netifaces (>=0.11.0) \
    python3-aiodns (>=3.1.1) \
    python3-ifaddr \
    python3-pyroute2 (>=0.7.3) \
    python3-cached-ipaddress (>=0.2.0) \
"

RDEPENDS:${PN}-ptest:append = " \
    python3-pytest-asyncio \
"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/aiodiscover/tests/* ${D}${PTEST_PATH}/tests/
}
