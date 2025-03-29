SUMMARY = "Utility functions for Python class constructs"
HOMEPAGE = "https://github.com/jaraco/jaraco.classes"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=141643e11c48898150daa83802dbc65f"

SRC_URI[sha256sum] = "47a024b51d0239c0dd8c8540c6c7f484be3b8fcf0b2d85c13825780d3b3f3acd"

inherit pypi python_setuptools_build_meta

DEPENDS += "python3-setuptools-scm-native"

PYPI_PACKAGE = "jaraco.classes"
