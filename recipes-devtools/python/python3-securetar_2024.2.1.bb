SUMMARY = "Secure Tarfile library"
HOMEPAGE = "https://github.com/pvizeli/securetar"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI[sha256sum] = "0475d5d515b52195e1c4095629834dbcf7038be39dea5b734faa59e4286ed068"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    python3-cryptography \
"
