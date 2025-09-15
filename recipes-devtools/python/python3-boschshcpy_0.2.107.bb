SUMMARY = "Bosch Smart Home Controller API Python Library"
HOMEPAGE = "https://github.com/tschamm/boschshcpy"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=aed7f4ee086d96ecac2da69872d75768"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f343132673f3c7956121deeb19e1e55f4300e189253c0bef3df2ae316fec1957"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-cryptography (>=3.3.2) \
    python3-getmac (>=0.8.2) \
    python3-requests (>=2.22) \
    python3-zeroconf (>=0.28.0) \
"

PYPI_PACKAGE = "boschshcpy"
