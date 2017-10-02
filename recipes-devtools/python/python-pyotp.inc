SUMMARY = "Python One Time Password Library"
HOMEPAGE = "https://github.com/pyotp/pyotp"
LICENSE = "MIT"
#TODO: https://github.com/pyotp/pyotp/issues/52
LIC_FILES_CHKSUM = "file://LICENSE;md5=fe3fe1d9ffcd1bfa15b860e8c62ce873"

inherit pypi

SRC_URI[md5sum] = "125ae00de613905bb8d3b4c12bd1e71d"
SRC_URI[sha256sum] = "dd9130dd91a0340d89a0f06f887dbd76dd07fb95a8886dc4bc401239f2eebd69"

BBCLASSEXTEND = "native"
