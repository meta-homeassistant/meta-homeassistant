SUMMARY = "Library implementing EZSP"
HOMEPAGE = "https://github.com/zigpy/bellows"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI += "file://0001-Allow-setuptools-git-versioning-3.patch"
SRC_URI[sha256sum] = "89974b6704351a145962fe6897a077f956b9633218fc3736d21539a6aeb9c8a4"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "bellows"

RDEPENDS:${PN} = "\
    python3-click \
    python3-click-log (>=0.2.1) \
    python3-pure-pcapy3 (>=1.0.1) \
    python3-voluptuous \
    python3-zigpy (>=0.70.0) \
"
