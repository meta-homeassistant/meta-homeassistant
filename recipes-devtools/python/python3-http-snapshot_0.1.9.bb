SUMMARY = "http-snapshot is a pytest plugin that snapshots requests made with popular Python HTTP clients."
HOMEPAGE = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=6398f880a8ff03de61b9685798c6cae3"

SRC_URI[sha256sum] = "22e6a1f0ff2836e14c33724213422d6351fe9513aafbbc5e0608cad9a2c5363c"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
	python3-inline-snapshot \
"

PYPI_PACKAGE = "http_snapshot"
