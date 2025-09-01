SUMMARY = "API client for the Channels app - https://getchannels.com"
HOMEPAGE = "https://github.com/fancybits/pychannels"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a3fa96b1724fb6ac9589bcde29f908fd"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5142d61daeef3a3db5c61267d810c7dc0597a074fc88e26c634a352a6197a132"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-requests (>=2.0)"

PYPI_PACKAGE = "pychannels"
