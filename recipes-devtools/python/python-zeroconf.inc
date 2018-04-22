SUMMARY = "Pure Python Multicast DNS Service Discovery Library (Bonjour/Avahi compatible)"
HOMEPAGE = "https://github.com/jstasiak/python-zeroconf"
LICENSE = "LGPL-2.1"
#TODO: Use correct file once is fixed: https://github.com/jstasiak/python-zeroconf/issues/97
#LIC_FILES_CHKSUM = "file://COPYING;md5=d7dba1721bc8ce05d421f7279cb87971"
LIC_FILES_CHKSUM = "file://setup.cfg;md5=4eda897c8cbf38795285525b225e9602"

inherit pypi

SRC_URI[md5sum] = "23124285dbdfcf3cb9cca11b98216cf7"
SRC_URI[sha256sum] = "6e3f1e7b5871e3d1410ac29b9fb85aafc1e2d661ed596b07a6f84559a475efcb"

RDEPENDS_${PN} = " \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-netifaces \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-threading \
    "
