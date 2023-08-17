SUMMARY = "Discover hosts by arp and ptr lookup"
HOMEPAGE = "https://github.com/bdraco/aiodiscover"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5c1e4dcca80a6a841c085ded9c25b768"

inherit pypi python_setuptools_build_meta

DEPENDS += "\
    python3-pytest-runner-native \
"

SRC_URI[sha256sum] = "245b9b6292217a38613220e4075a47397874a70052acd2da0801c51642648869"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-async-timeout (>=4.0.1) \
    ${PYTHON_PN}-netifaces (>=0.11.0) \
    ${PYTHON_PN}-dnspython (>=2.3.0) \
    ${PYTHON_PN}-ifaddr \
    ${PYTHON_PN}-pyroute2 (>=0.7.3) \
"