SUMMARY = "Iterative JSON parser with standard Python iterator interfaces"
HOMEPAGE = "https://github.com/ICRAR/ijson"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=37546ad605c4c34c5c9faf9e1f9c2559"

SRC_URI[sha256sum] = "5f74dcbad9d592c428d3ca3957f7115a42689ee7ee941458860900236ae9bb13"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "ijson"
