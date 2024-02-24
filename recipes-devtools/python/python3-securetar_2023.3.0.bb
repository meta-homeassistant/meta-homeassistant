SUMMARY = "Secure Tarfile library"
HOMEPAGE = "https://github.com/pvizeli/securetar"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI[sha256sum] = "f362e338fcf572ac65d062b5e5c31067605362ed412d4f553ac2ed9efe7ed498"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    python3-cryptography \
"
