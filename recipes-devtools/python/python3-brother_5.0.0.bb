SUMMARY = "Python wrapper for getting data from Brother laser and inkjet printers via SNMP."
HOMEPAGE = "https://github.com/bieniu/brother"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9f5299ee44ddbc3e1aa12f36d96ff584"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "899e05835240151bab526ada73e8aed4936c9f39e717f8ec65a24eedd4cd1238"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-dacite (>=1.7.0) \
    python3-pysnmp (>=7.1.6) \
"

PYPI_PACKAGE = "brother"
