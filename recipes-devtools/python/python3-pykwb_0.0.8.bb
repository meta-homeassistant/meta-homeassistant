SUMMARY = "KWB Easyfire serial library, for inclusion into homeassistant"
HOMEPAGE = "https://github.com/bimbar/pykwb.git"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=9fc306bc8bfce4375f3500f34cb73bb6"

SRC_URI[sha256sum] = "66a396b9d5176b93b8b8407a969fdaf247b4d0dc8824ee7027714dab2d118ae5"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-pyserial (>=3.0.1) \
"
