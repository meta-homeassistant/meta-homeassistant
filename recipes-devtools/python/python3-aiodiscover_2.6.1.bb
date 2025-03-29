SUMMARY = "Discover hosts by arp and ptr lookup"
HOMEPAGE = "https://github.com/bdraco/aiodiscover"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bb5cee7a63edfb80ada99f0db1e4ed62"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "\
    git://github.com/bdraco/aiodiscover.git;protocol=https;branch=main \
    file://run-ptest \
"
SRC_URI[sha256sum] = "73846ff8b85abaffaaa0ad4fad5965b76c7d518878ecdd0e5dcf1126d77a57c7"
SRCREV = "f76c7915091a9e91d67ed69f5e2ba95de1262380"

inherit  python_poetry_core ptest

S = "${WORKDIR}/git"

RDEPENDS:${PN} = "\
    python3-async-timeout (>=4.0.1) \
    python3-netifaces (>=0.11.0) \
    python3-aiodns (>=3.1.1) \
    python3-ifaddr \
    python3-pyroute2 (>=0.7.3) \
    python3-cached-ipaddress (>=0.2.0) \
"

RDEPENDS:${PN}-ptest = "\
    python3-pytest \
    python3-pytest-asyncio \
    python3-unittest-automake-output \
"

do_install_ptest() {
    install -d ${D}${PTEST_PATH}/tests
    cp -rf ${S}/aiodiscover/tests/* ${D}${PTEST_PATH}/tests/
}
