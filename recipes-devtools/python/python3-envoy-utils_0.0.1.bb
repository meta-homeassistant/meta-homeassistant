SUMMARY = "Python utilities for the Enphase Envoy"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=db95b6e40dc7d26d8308b6b7375637b6"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "0cc435b2b9a8c2a664530c85bfd108e4bd7500079aa1bb93a69628314d03f68f"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-zeroconf"

PYPI_PACKAGE = "envoy_utils"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
