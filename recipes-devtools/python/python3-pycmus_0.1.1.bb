SUMMARY = "A python cmus remote library"
HOMEPAGE = "http://pycmus.readthedocs.io/en/latest/"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5a4f49fd78ca641d77a3c426741c9558770075f34e89cc0b687d92878a89708c"

DEPENDS += "python3-pbr-native"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-pbr (>=1.6) \
    python3-six (>=1.9.0) \
"

PYPI_PACKAGE = "pycmus"
