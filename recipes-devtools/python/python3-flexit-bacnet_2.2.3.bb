SUMMARY = "Client BACnet library for Flexit Nordic series of air handling units."
HOMEPAGE = "https://github.com/piotrbulinski/flexit_bacnet"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b422146e467c76bd5ad5f3d8204a7d77"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "ffb93f53d3bc42ca3767a0868cd76f7f93b71932e8a392966ea0505cdd224d9b"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "flexit_bacnet"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
