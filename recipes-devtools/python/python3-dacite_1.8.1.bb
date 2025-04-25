SUMMARY = "Simple creation of data classes from dictionaries."
HOMEPAGE = "https://github.com/konradhalas/dacite"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=72f6cbdc854c4c393ac30db3dbba2766"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/konradhalas/dacite;protocol=https;branch=master"
SRCREV = "10a9ec40fc5874ae434aa68b975d1b1bf667a42f"

S = "${WORKDIR}/git"

inherit python_setuptools_build_meta
