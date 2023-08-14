SUMMARY = "Discover hosts by arp and ptr lookup"
HOMEPAGE = "https://github.com/bdraco/aiodiscover"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5c1e4dcca80a6a841c085ded9c25b768"

inherit pypi python_setuptools_build_meta

DEPENDS += "\
    python3-pytest-runner-native \
"

SRC_URI[sha256sum] = "293a4653fbb0f52f114c51bdefc8c27f6ac6087f6b4bc0a7c5f3757b9abef2cf"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-async-timeout (>=4.0.1) \
    ${PYTHON_PN}-netifaces (>=0.11.0) \
    ${PYTHON_PN}-dnspython (>=2.1.0) \
    ${PYTHON_PN}-ifaddr \
    ${PYTHON_PN}-pyroute2 (>=0.7.3) \
"