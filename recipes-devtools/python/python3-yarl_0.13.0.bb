SUMMARY = "Yet another URL library"
HOMEPAGE = "https://github.com/aio-libs/yarl/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=22522b8f7ca5b78025a4fb540c948907"

inherit pypi setuptools3

SRC_URI[md5sum] = "734ca04d8689157351e3cd5ec3f8d130"
SRC_URI[sha256sum] = "25fe681a982f2cec567df8abac7cbd2ac27016e4aec89193945cab0643bfdb42"

RDEPENDS_${PN} = "${PYTHON_PN}-multidict"
