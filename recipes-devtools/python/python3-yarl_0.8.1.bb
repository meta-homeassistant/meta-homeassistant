SUMMARY = "Yet another URL library"
HOMEPAGE = "https://github.com/aio-libs/yarl/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"

inherit pypi setuptools3

SRC_URI[md5sum] = "34f60a148ab55e3bfde2c0efd7026308"
SRC_URI[sha256sum] = "9f0397ae540124bf16a8a5b89bc3ea1c07f8ae70c3e44231a40a9edd254d5712"

RDEPENDS_${PN} = "${PYTHON_PN}-multidict"
