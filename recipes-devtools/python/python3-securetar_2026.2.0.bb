SUMMARY = "Secure Tarfile library"
HOMEPAGE = "https://github.com/pvizeli/securetar"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/pvizeli/securetar;protocol=https;tag=${PV};branch=main"
SRCREV = "d469581c5e641de460d87b5da54d567564415080"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-cryptography \
    python3-pynacl \
"
