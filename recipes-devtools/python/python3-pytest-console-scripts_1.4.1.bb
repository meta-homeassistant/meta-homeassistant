SUMMARY = "Pytest plugin for testing console scripts"
HOMEPAGE = "https://github.com/kvas-it/pytest-console-scripts"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c202a41646e540cc370342197e856468"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5a826ed84cc0afa202eb9e44381d7d762f7bdda8e0c23f9f79a7f1f44cf4a895"

DEPENDS += "python3-setuptools-scm-native"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "python3-pytest"

PYPI_PACKAGE = "pytest-console-scripts"
