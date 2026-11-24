SUMMARY = "Models GTFS data in a database."
HOMEPAGE = "https://github.com/jarondl/pygtfs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://license.txt;md5=cc397dbc38c8c934fec383f76db96f15"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "35a4868f304114ade6a8789b70a576810210a169fea996b2eca25ab23730c56e"

DEPENDS = "python3-setuptools-scm-native"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-docopt \
    python3-pytz (>=2014.9) \
    python3-sqlalchemy (>=0.7.8) \
"
