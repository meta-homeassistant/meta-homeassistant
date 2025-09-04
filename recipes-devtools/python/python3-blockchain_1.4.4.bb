SUMMARY = "Blockchain API library (v1)"
HOMEPAGE = "https://github.com/blockchain/api-v1-client-python/releases/tag/1.4.3"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "dbaa3eebb6f81b4245005739da802c571b09f98d97eb66520afd95d9ccafebe2"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-enum-compat python3-future"

PYPI_PACKAGE = "blockchain"
