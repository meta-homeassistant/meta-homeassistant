SUMMARY = "KWB Easyfire serial library, for inclusion into homeassistant"
HOMEPAGE = "https://github.com/bimbar/pykwb.git"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "66a396b9d5176b93b8b8407a969fdaf247b4d0dc8824ee7027714dab2d118ae5"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-pyserial (>=3.0.1) \
"
