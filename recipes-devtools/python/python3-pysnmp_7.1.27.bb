SUMMARY = "A Python library for SNMP"
HOMEPAGE = "https://pysnmp.com/"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.rst;md5=57ee828406c11080ad9bd7eabdc5ae1b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "01ce32d1bb0a14e8e3410a43fb7a8a7b050ec06186dc9ec240fcefa4af8b963c"

inherit pypi python_flit_core

RDEPENDS:${PN} = "\
	python3-pyasn1 (>=0.4.8) \
"
