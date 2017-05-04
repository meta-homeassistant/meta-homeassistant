SUMMARY = "read and write audio tags for many formats"
HOMEPAGE = "https://github.com/quodlibet/mutagen"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS += "${PYTHON_PN}-cython-native"

inherit pypi

SRC_URI[md5sum] = "da993427407854c94d491824666293ba"
SRC_URI[sha256sum] = "539553d3f1ffd890c74f64b819750aef0316933d162c09798c9e7eaf334ae760"
