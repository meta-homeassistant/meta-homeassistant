SUMMARY = "devolo PLC devices in Python"
HOMEPAGE = "https://github.com/2Fake/devolo_plc_api"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "44864710d76315b7e0bd9e37c0949804b2e31dde27a815b3b47d8c6a43892fec"

DEPENDS += "python3-setuptools-scm-native"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += " \
	python3-ifaddr (>=0.1.7) \
	python3-httpx (>=0.21.0) \
	python3-protobuf (>=4.22.0) \
	python3-segno (>=1.5.2) \
	python3-tenacity (>=8.3.0) \
	python3-zeroconf (>=0.70.0) \
"

PYPI_PACKAGE = "devolo_plc_api"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
