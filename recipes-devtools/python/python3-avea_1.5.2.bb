SUMMARY = "Control an Elgato Avea bulb using python3"
HOMEPAGE = "https://github.com/k0rventen/avea"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da981d94d3cd3e010abf14da3a7e79a0"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "417ba45e63029a593538f9ea94a562177d5d89ca8f7a3ed6a4f3325ce0aeb564"

inherit pypi setuptools3

RDEPENDS:${PN} += "bluepy"

PYPI_PACKAGE = "avea"
