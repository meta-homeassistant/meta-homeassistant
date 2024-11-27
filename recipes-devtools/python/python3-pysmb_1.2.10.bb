SUMMARY = "pysmb is an experimental SMB/CIFS library written in Python to support file sharing between Windows and Linux machines"
HOMEPAGE = "https://miketeo.net/projects/pysmb"
LICENSE = "Zlib"
LIC_FILES_CHKSUM = "file://LICENSE;md5=06f070053828db68be36bd1c8c95ca5e"

SRC_URI[sha256sum] = "5796253bf10d0c5fbeae3d5ae89c66c275d1b3e547f0bc55b7d4799168b19076"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-pyasn1 \
    python3-tqdm \
"

PYPI_PACKAGE = "pysmb"
PYPI_PACKAGE_EXT = "zip"
