SUMMARY = "Python wrapper for getting data from Brother laser and inkjet printers via SNMP."
HOMEPAGE = "https://github.com/bieniu/brother"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=294a75dc2aa13b607c79c0a9ac06e800"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "6682b40029987a5557cb182143753cec53753420de8827c52a799e9180a3bf90"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-dacite (>=1.7.0) \
    python3-pysnmp (>=7.1.6) \
"

PYPI_PACKAGE = "brother"
