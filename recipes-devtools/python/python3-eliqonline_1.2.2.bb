SUMMARY = "Eliq Online API Library"
HOMEPAGE = "https://github.com/6d66/eliq/"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=23f9ad5cad3d8cc0336e2a5d8a87e1fa"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "84e50de1c038a4a562a08adf24cd3618e9d974345cef16cdb6f1dfa03dfffdb3"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp python3-docopt python3-pyyaml"

PYPI_PACKAGE = "eliqonline"
