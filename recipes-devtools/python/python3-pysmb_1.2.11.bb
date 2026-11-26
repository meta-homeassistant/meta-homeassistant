SUMMARY = "pysmb is an experimental SMB/CIFS library written in Python to support file sharing between Windows and Linux machines"
HOMEPAGE = "https://miketeo.net/projects/pysmb"
LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://LICENSE;md5=148dfe87589388f86bab72dd27ab8fa1"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3a33214f737e877a8ead579e63c9944941deff5e12100e1ca65311b230b1786a"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-pyasn1 \
    python3-tqdm \
"

PYPI_PACKAGE_EXT = "zip"
