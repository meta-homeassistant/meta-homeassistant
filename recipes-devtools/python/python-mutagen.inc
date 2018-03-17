SUMMARY = "read and write audio tags for many formats"
HOMEPAGE = "https://github.com/quodlibet/mutagen"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS += "${PYTHON_PN}-cython-native"

inherit pypi

SRC_URI[md5sum] = "930111584992af3239ac5c1d979c4edb"
SRC_URI[sha256sum] = "b2a2c2ce87863af12ed7896f341419cd051a3c72c3c6733db9e83060dcadee5e"
