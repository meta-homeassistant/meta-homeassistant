SUMMARY = "Aranet Python client"
HOMEPAGE = "https://github.com/Anrijs/Aranet4-Python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=54a45dff2e26b69b5a1ef76960aea172"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "345152ad49f07362d9ecd1aad60406e8126dafca484e7796bc8b1eece6990c99"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-bleak python3-requests"

PYPI_PACKAGE = "aranet4"
