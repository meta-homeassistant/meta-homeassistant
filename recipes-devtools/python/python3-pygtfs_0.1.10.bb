SUMMARY = "Models GTFS data in a database."
HOMEPAGE = "https://github.com/jarondl/pygtfs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://license.txt;md5=cc397dbc38c8c934fec383f76db96f15"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "6ce1bf6d7cfdede58cefb029ad0bc482d97d8367d06db29cc27885d5f002d1dd"

DEPENDS = "python3-setuptools-scm-native"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-docopt \
    python3-pytz (>=2014.9) \
    python3-six \
    python3-sqlalchemy (>=0.7.8) \
"

PYPI_PACKAGE = "pygtfs"
