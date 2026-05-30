SUMMARY = "A Python library for SNMP"
HOMEPAGE = "https://pysnmp.com/"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=d4aed8ba2a0ff36c85e2753b66c36b45"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "37ac595c7f0c1c00514505939b4dcf5b4fd5a9ffe51b0349f60bb640c11b0f77"

inherit pypi python_flit_core

RDEPENDS:${PN} = "\
	python3-pyasn1 (>=0.4.8) \
"

PYPI_PACKAGE = "pysnmp"
