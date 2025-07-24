SUMMARY = "Library and CLI tools for interacting with buienradar."
HOMEPAGE = "https://github.com/mjj4791/python-buienradar"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a7793699f1bef841dd8a8a63cbd78463"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7de6011cdb646b2bca8898048d283dbb6b5c4a43cb108827b14cc558df2b276b"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-docopt python3-pytz python3-requests python3-vincenty python3-xmltodict"

PYPI_PACKAGE = "buienradar"
