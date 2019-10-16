SUMMARY = "Pure Python Multicast DNS Service Discovery Library (Bonjour/Avahi compatible)"
HOMEPAGE = "https://github.com/jstasiak/python-zeroconf"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://setup.cfg;md5=ff6c93e702a31eff8923f98b5bb92ec2"

inherit pypi

SRC_URI[md5sum] = "1094639f8688f2c5b1938029877eb4f2"
SRC_URI[sha256sum] = "e0c333b967c48f8b2e5cc94a1d4d28893023fb06dfd797ee384a94cdd1d0eef5"

RDEPENDS_${PN} = " \
    ${PYTHON_PN}-ifaddr \
"
