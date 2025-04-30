SUMMARY = "Secure Tarfile library"
HOMEPAGE = "https://github.com/pvizeli/securetar"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "59536a73fe5cecbc1f00b1838c8b1052464a024e2adcf6c9ce1d200d91990fb1"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-cryptography \
"
