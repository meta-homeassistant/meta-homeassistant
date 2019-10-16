SUMMARY = "Python implementation of ua-parser "
HOMEPAGE = "https://github.com/ua-parser/uap-python"
LICENSE = "Apache-2.0"
#TODO: https://github.com/ua-parser/uap-python/pull/58
LIC_FILES_CHKSUM = "file://setup.py;md5=444ad3ad927eaa749de9221af5f70f24"

inherit pypi setuptools3

SRC_URI[md5sum] = "b73c5a86783e444afa2788075dddf48a"
SRC_URI[sha256sum] = "97bbcfc9321a3151d96bb5d62e54270247b0e3be0590a6f2ff12329851718dcb"

DEPENDS += "\
    ${PYTHON_PN}-pyyaml-native \
"
