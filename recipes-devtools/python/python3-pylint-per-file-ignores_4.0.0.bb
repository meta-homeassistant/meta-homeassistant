SUMMARY = "A pylint plugin to ignore error codes per file."
HOMEPAGE = "https://github.com/SAP/pylint-per-file-ignores"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=835114f14116c97491ebf076aa9c7257"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "0b685cc095c4a9cc37831c23d67c88fdd870c1c7df080c32f93cd5d8cc239cde"

DEPENDS = "python3-setuptools-scm-native"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "python3-pylint"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-cov \
    python3-pytest-randomly \
    python3-pytest-datadir \
    python3-pytest-fixture-classes \
"

PTEST_PYTEST_DIR = "test"
