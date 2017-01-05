SUMMARY = "Pure Python Multicast DNS Service Discovery Library (Bonjour/Avahi compatible)"
HOMEPAGE = "https://github.com/jstasiak/python-zeroconf"
LICENSE = "LGPL-2.1"
#TODO: Use correct file once is fixed: https://github.com/jstasiak/python-zeroconf/issues/97
#LIC_FILES_CHKSUM = "file://COPYING;md5=d7dba1721bc8ce05d421f7279cb87971"
LIC_FILES_CHKSUM = "file://setup.cfg;md5=cf04fd2579dfe8a0141e3520b3eb0ceb"

inherit pypi

SRC_URI[md5sum] = "526c9e59c3d51e9e3b688922f8fc4ecd"
SRC_URI[sha256sum] = "b614baa73833bdfc8ae64f2a9f5d19b014ad3164fbbc8513ef27a7bbe1e6c5e3"

RDEPENDS_${PN} = " \
    ${PYTHON_PN}-logging \
    ${PYTHON_PN}-netifaces \
    ${PYTHON_PN}-re \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-threading \
    "
