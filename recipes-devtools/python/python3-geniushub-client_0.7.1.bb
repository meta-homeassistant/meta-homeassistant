SUMMARY = "An aiohttp-based client for Genius Hub systems"
HOMEPAGE = "https://github.com/manzanotti/geniushub-client"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d969eabee386a82b26ce6c7391754ae6"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-Fix-version.patch"
SRC_URI[sha256sum] = "22bd773edaac9e5f3a2b8d6675b825fcb90acaa7587eb5b8e088645c861cd8d6"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp (>=3.7.4)"

PYPI_PACKAGE = "geniushub-client"
