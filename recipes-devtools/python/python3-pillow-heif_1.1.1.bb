SUMMARY = "Python interface for libheif library"
HOMEPAGE = "https://github.com/bigcat88/pillow_heif"
LICENSE = "BSD-3-Clause & GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b6c07a92aed67c33bc346748d7c7e991 \
                    file://LICENSES_bundled.txt;md5=57b2c81d3026f29964bd1f98054e2700 \
                    file://tests/images/heif_other/nokia/COPYRIGHT.txt;md5=1740aa8cd2e34ffbc22afcc982be69ed"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f60e8c8a8928556104cec4fff39d43caa1da105625bdb53b11ce3c89d09b6bde"

DEPENDS += "libheif"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "python3-pillow"

RDEPENDS:${PN}-ptest = "python3-defusedxml python3-packaging"

PYPI_PACKAGE = "pillow_heif"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
