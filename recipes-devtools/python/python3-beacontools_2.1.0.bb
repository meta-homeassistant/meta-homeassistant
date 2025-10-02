SUMMARY = "A Python library for working with various types of Bluetooth LE Beacons."
HOMEPAGE = "https://github.com/citruz/beacontools"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=cbd455744c786852e7840d7ccfb817ab"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "1676832e14e702f0d4784ea47c1ac20d7044c89befce2e4b895798b32dcf0731"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-ahocorapy (>=1.6.1) \
    python3-construct (>=2.9.52) \
"

PYPI_PACKAGE = "beacontools"
