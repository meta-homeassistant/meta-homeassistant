SUMMARY = "Python library to access the FYTA API"
HOMEPAGE = "https://fyta.de/"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "bc6bdd5c362c391102bda44469f258474b8f9f8ffcc82118a81af4488fd47200"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-mashumaro (>=3.13) \
"
