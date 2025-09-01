SUMMARY = "ClearPass API Python Library"
HOMEPAGE = "https://github.com/zemerick1/clearpasspy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=57;endline=57;md5=1a0b8f6cfcb0fbef4ff6d0bf7a4eeb7d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "1c08bdcfb0d3e60d0f92bfab01250ad7cfed12ca2b59749c08e0c4f7943e659d"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-requests (>=2.21.0)"

PYPI_PACKAGE = "clearpasspy"
