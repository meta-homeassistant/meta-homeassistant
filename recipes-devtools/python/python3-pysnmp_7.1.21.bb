SUMMARY = "A Python library for SNMP"
HOMEPAGE = "https://pysnmp.com/"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=d4aed8ba2a0ff36c85e2753b66c36b45"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d5fa54cf2021af1c93a439eec66ce716fc8df425c55ecc7ed5bca9f35e8145b2"

inherit pypi python_flit_core

RDEPENDS:${PN} = "\
	python3-pyasn1 (>=0.4.8) \
"

PYPI_PACKAGE = "pysnmp"
