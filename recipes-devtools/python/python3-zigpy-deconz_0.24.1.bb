SUMMARY = "A library which communicates with Deconz radios for zigpy"
HOMEPAGE = "https://github.com/zigpy/zigpy-deconz"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"

DEPENDS += "\
    python3-setuptools-git-versioning-native \
"

SRC_URI += "file://0001-Allow-setuptools-git-versioning-3.patch"
SRC_URI[sha256sum] = "c72a33ab9ca175f1c874b5fdc52b20b692a068dcd73d46973a4a097c3e8d6062"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "zigpy_deconz"

RDEPENDS:${PN} = "\
    python3-voluptuous \
    python3-zigpy (>=0.70.0) \
"
