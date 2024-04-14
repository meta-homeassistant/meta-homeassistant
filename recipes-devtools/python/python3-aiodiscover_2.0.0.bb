SUMMARY = "Discover hosts by arp and ptr lookup"
HOMEPAGE = "https://github.com/bdraco/aiodiscover"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5c1e4dcca80a6a841c085ded9c25b768"

inherit pypi python_setuptools_build_meta

DEPENDS += "\
    python3-pytest-runner-native \
"

SRC_URI[sha256sum] = "73846ff8b85abaffaaa0ad4fad5965b76c7d518878ecdd0e5dcf1126d77a57c7"

RDEPENDS:${PN} = "\
    python3-async-timeout (>=4.0.1) \
    python3-netifaces (>=0.11.0) \
    python3-aiodns (>=3.1.1) \
    python3-ifaddr \
    python3-pyroute2 (>=0.7.3) \
    python3-cached-ipaddress (>=0.2.0) \
"