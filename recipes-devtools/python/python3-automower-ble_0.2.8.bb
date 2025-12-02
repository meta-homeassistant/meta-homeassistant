SUMMARY = "An unofficial reverse engineered Husqvarna Automower Connect BLE library"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "41ec740664f3e6a611d102d5fa86c3f42da7cb8bf880411111ef8ecb3c5aa0a4"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "automower_ble"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
RDEPENDS:${PN} = "python3-bleak python3-bleak-retry-connector"
