SUMMARY = "Python SEPA XML implementations"
HOMEPAGE = "https://github.com/raphaelm/python-sepaxml"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=10ff9018be626ef05e68684d3a78cab2"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"


SRC_URI[sha256sum] = "77c6ea8c4ea59e53dcabed1d5d8bb79559a0aac47cf25c8e78b06ff5fef6c2bd"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-text-unidecode python3-xmlschema"
