SUMMARY = "a library for controlling certain robot vacuums"
HOMEPAGE = "https://github.com/mib1185/py-sucks"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=d32239bcb673463ab874e80d47fae504"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "41aea9873e7ff9898cfeb4393be83f3d324265dc675503a2f6e38d6cb4ac9e64"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-pycryptodome (>=3.4) \
    python3-requests (>=2.18) \
    python3-sleekxmppfs (>=1.4.1) \
"

PYPI_PACKAGE = "py-sucks"
