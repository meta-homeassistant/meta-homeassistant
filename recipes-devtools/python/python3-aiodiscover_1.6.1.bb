SUMMARY = "Discover hosts by arp and ptr lookup"
HOMEPAGE = "https://github.com/bdraco/aiodiscover"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5c1e4dcca80a6a841c085ded9c25b768"

inherit pypi python_setuptools_build_meta

DEPENDS += "\
    python3-pytest-runner-native \
"

SRC_URI[sha256sum] = "9f9382f6e9152b102e05512cc9736126ab8f165e217d0168fee5579c24443c9e"

RDEPENDS:${PN} = "\
    python3-async-timeout (>=4.0.1) \
    python3-netifaces (>=0.11.0) \
    python3-dnspython (>=2.3.0) \
    python3-ifaddr \
    python3-pyroute2 (>=0.7.3) \
    python3-cached-ipaddress (>=0.2.0) \
"