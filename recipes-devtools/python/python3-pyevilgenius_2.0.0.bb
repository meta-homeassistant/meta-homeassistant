SUMMARY = "Python module to talk to Evil Genius Labs devices."
HOMEPAGE = "https://github.com/home-assistant-libs/pyevilgenius"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "0dcf3bf5c6347650efd9bd3c13f37650439c181736fba34ae7228023ea9035ae"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp python3-async-timeout"

PYPI_PACKAGE = "pyevilgenius"
