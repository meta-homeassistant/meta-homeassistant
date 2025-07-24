SUMMARY = "Simple API wrapper to brottsplatskartan.se."
HOMEPAGE = "https://github.com/chrillux/brottsplatskartan"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5a184075c38f263d7d59a5fcf5ec05e7bd82f2ae699e8f054f3bc220a4ef2113"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-requests (>=2.20.0)"

PYPI_PACKAGE = "brottsplatskartan"
