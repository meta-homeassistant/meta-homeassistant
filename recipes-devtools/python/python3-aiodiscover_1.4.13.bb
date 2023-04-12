SUMMARY = "Discover hosts by arp and ptr lookup"
HOMEPAGE = "https://github.com/bdraco/aiodiscover"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5c1e4dcca80a6a841c085ded9c25b768"

inherit pypi python_setuptools_build_meta

DEPENDS += "\
    python3-pytest-runner-native \
"

SRC_URI[md5sum] = "92bbcd8e6c02159e350290edd579ca74"
SRC_URI[sha256sum] = "8185d9ae2b94af7eb5fac963a74da796c708a05c94fe5f817072900c80a196ad"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-async-timeout (>=4.0.1) \
    ${PYTHON_PN}-netifaces (>=0.11.0) \
    ${PYTHON_PN}-dnspython (>=2.1.0) \
    ${PYTHON_PN}-ifaddr (>=0.2.0) \
    ${PYTHON_PN}-pyroute2 (>=0.7.3) \
"