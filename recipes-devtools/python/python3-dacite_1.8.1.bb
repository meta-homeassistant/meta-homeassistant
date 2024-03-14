SUMMARY = "Simple creation of data classes from dictionaries."
HOMEPAGE = "https://github.com/konradhalas/dacite"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=72f6cbdc854c4c393ac30db3dbba2766"

SRC_URI = "git://github.com/konradhalas/dacite;protocol=https;branch=master;tag=v${PV}"

S = "${WORKDIR}/git"

inherit python_setuptools_build_meta
