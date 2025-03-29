SUMMARY = "Discover hosts by arp and ptr lookup"
HOMEPAGE = "https://github.com/bdraco/aiodiscover"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5c1e4dcca80a6a841c085ded9c25b768"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "\
    git://github.com/bdraco/aiodiscover.git;protocol=https;branch=main \
    file://run-ptest \
"
SRC_URI[sha256sum] = "73846ff8b85abaffaaa0ad4fad5965b76c7d518878ecdd0e5dcf1126d77a57c7"
SRCREV = "2e79d022a2f6cc854cd3adbee02ccc75a90336eb"

inherit  python_setuptools_build_meta ptest

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
