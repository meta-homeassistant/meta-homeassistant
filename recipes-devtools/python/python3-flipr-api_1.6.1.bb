SUMMARY = "Python client for flipr API"
HOMEPAGE = "https://github.com/cnico/flipr-api"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=f4eda51018051de136d3b3742e9a7a40"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/cnico/flipr-api.git;branch=main;protocol=https"
SRCREV = "b4dd6fdc6370846f59b87eb63865859b04f324ee"

inherit python_poetry_core

RDEPENDS:${PN} += "\
    python3-dateutil \
    python3-requests \
"
