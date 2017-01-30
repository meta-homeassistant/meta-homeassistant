SUMMARY = "Provide HDMI CEC devices as objects, especially for use with Home Assistant"
HOMEPAGE = "https://github.com/konikvranik/pycec/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e62476f516ba645845916e686710652f"

PYPI_PACKAGE = "pyCEC"
PYPI_PACKAGE_EXT = "zip"
inherit pypi setuptools3

SRC_URI[md5sum] = "e1c9d29f4ff7be2e7d6f45df13dc5d97"
SRC_URI[sha256sum] = "28725a9ab4adf5513894ec42951c873545edd7d9acdb92282766133fbe957a68"

RDEPENDS_${PN} = "python3-libcec"
