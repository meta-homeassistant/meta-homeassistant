SUMMARY = "Pure Python Multicast DNS Service Discovery Library (Bonjour/Avahi compatible)"
HOMEPAGE = "https://github.com/jstasiak/python-zeroconf"
LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://setup.cfg;md5=465c797d889058539f81d56da72b42a4"

inherit pypi

SRC_URI[md5sum] = "1eae70b5291cdd0dc4292781ec051cc3"
SRC_URI[sha256sum] = "893a841445663e0c4c20d1111ce41484bd62d58f59d653d0485187343368ef4a"

RDEPENDS:${PN} = " \
    ${PYTHON_PN}-ifaddr \
"
