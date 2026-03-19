SUMMARY = "Aranet Python client"
HOMEPAGE = "https://github.com/Anrijs/Aranet4-Python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54a45dff2e26b69b5a1ef76960aea172"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3821fc19d3572b0cbea8c0f913155b215126575f87361f41eb146f0c3c49e01a"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-bleak python3-requests"

PYPI_PACKAGE = "aranet4"
