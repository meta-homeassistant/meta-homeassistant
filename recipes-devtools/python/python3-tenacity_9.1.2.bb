SUMMARY = "Retry code until it succeeds"
HOMEPAGE = "https://github.com/jd/tenacity"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=175792518e4ac015ab6696d16c4f607e"

SRC_URI[sha256sum] = "1169d376c297e7de388d18b4481760d478b0e99a777cad3a9c86e556f4b697cb"

DEPENDS += "python3-setuptools-scm-native"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "tenacity"
