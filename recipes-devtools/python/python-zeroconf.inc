SUMMARY = "Pure Python Multicast DNS Service Discovery Library (Bonjour/Avahi compatible)"
HOMEPAGE = "https://github.com/jstasiak/python-zeroconf"
LICENSE = "LGPL-2.1"
#TODO: Use correct file once is fixed: https://github.com/jstasiak/python-zeroconf/issues/97
#LIC_FILES_CHKSUM = "file://COPYING;md5=d7dba1721bc8ce05d421f7279cb87971"
LIC_FILES_CHKSUM = "file://setup.cfg;md5=4eda897c8cbf38795285525b225e9602"

inherit pypi

SRC_URI[md5sum] = "12d4cb1eef96c38cd8760a68a83809d4"
SRC_URI[sha256sum] = "434eab8da9525ae725d6842aae7e59d9ec6580bdc5ae84f3c225240bc6797f7a"

RDEPENDS_${PN} = " \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-netifaces \
    ${PYTHON_PN}-re \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-threading \
    "
