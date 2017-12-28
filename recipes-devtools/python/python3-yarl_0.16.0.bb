SUMMARY = "Yet another URL library"
HOMEPAGE = "https://github.com/aio-libs/yarl/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=22522b8f7ca5b78025a4fb540c948907"

inherit pypi setuptools3

SRC_URI[md5sum] = "af841bd257c3bf3ce5270b4522e92cd4"
SRC_URI[sha256sum] = "47622985ecd9b15335d65c1acd54aeb3ba449e6d09b36e37ecfe334c7e7b8d0b"

RDEPENDS_${PN} = "${PYTHON_PN}-multidict"
