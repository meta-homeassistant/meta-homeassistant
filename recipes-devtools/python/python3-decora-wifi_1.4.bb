SUMMARY = "Python API for controlling Leviton Decora Smart WiFi switches"
HOMEPAGE = "http://github.com/tlyakhov/python-decora_wifi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=23f9ad5cad3d8cc0336e2a5d8a87e1fa"

SRC_URI[sha256sum] = "04842cb31129c022328f9cf43767aff5c26bff2f74ee0d0b6fb879883f5d0293"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-inflect \
    python3-requests \
"

PYPI_PACKAGE = "decora_wifi"
