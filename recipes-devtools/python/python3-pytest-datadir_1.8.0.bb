SUMMARY = "pytest plugin for test data directories and files"
HOMEPAGE = "http://github.com/gabrielcnr/pytest-datadir"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=711d07394a9f47230d6ac7d7003b8e97"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7a15faed76cebe87cc91941dd1920a9a38eba56a09c11e9ddf1434d28a0f78eb"

DEPENDS = "python3-setuptools-scm-native"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "python3-pytest"
