SUMMARY = "Python client for flipr API"
HOMEPAGE = "https://github.com/cnico/flipr-api"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/cnico/flipr-api.git;branch=main;protocol=https"
SRCREV = "b4dd6fdc6370846f59b87eb63865859b04f324ee"

inherit python_poetry_core

RDEPENDS:${PN} += "\
    python3-dateutil \
    python3-requests \
"
