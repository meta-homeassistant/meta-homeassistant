SUMMARY = "API to interact with a Dormakaba dkey lock via bluetooth"
HOMEPAGE = "https://github.com/emontnemery/py-dormakaba-dkey"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5a588bcbe30e4d6b149fa57244eede5e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-relax-build-req.patch"
SRC_URI[sha256sum] = "f1c25e8432f699da98a2503a3e6a79937aad076f4ca4b9c6361107558e9388bc"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "py-dormakaba-dkey"
