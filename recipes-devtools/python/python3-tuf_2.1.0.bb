SUMMARY = "A secure updater framework for Python"
HOMEPAGE = "https://www.updateframework.com"
LICENSE = "Apache-2.0 & MIT"
LIC_FILES_CHKSUM = "\
    file://LICENSE;md5=8cc789b082b3d97e1ccc5261f8594d3f \
    file://LICENSE-MIT;md5=0905c600830081fce64622608c4a2628 \
"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI += "file://0001-Allow-newer-version-of-hatchling.patch"
SRC_URI[sha256sum] = "dbfe18fbdeba6d76144931db88b76e473fa40c431b60d25b455a9adbb07c2397"

inherit pypi python_hatchling

PYPI_PACKAGE = "tuf"

RDEPENDS:${PN} = "\
    python3-requests \
    python3-securesystemslib \
"
