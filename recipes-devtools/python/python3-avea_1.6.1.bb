SUMMARY = "Control an Elgato Avea bulb using python3"
HOMEPAGE = "https://github.com/k0rventen/avea"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da981d94d3cd3e010abf14da3a7e79a0"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7b3de41ce454330bf503a38f13ebeaef6a57770aea75c06653d1a8bb52243f9f"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-bleak python3-bleak-retry-connector"

PYPI_PACKAGE = "avea"
