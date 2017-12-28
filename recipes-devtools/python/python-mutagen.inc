SUMMARY = "read and write audio tags for many formats"
HOMEPAGE = "https://github.com/quodlibet/mutagen"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS += "${PYTHON_PN}-cython-native"

inherit pypi

SRC_URI[md5sum] = "f26b79f9198279dfb963c928b5ed3eca"
SRC_URI[sha256sum] = "9da92566458ffe5618ffd26167abaa8fd81f02a7397b8734ec14dfe14e8a19e4"
