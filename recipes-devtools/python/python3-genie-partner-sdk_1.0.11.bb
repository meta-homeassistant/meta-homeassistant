SUMMARY = "An SDK to interact with the AladdinConnect (or OHD) partner API"
HOMEPAGE = "https://github.com/genie-garage/aladdin-python-sdk"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1e60c3d74e822ce961dd8add372bbbdf"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "78d78dfa6b693f363aa74895a3fa2dd1e2f36bf69e24fef43f1347c7bfcc5686"

inherit pypi python_hatchling

PYPI_PACKAGE = "genie_partner_sdk"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
