SUMMARY = "Official Python API client for Discogs"
HOMEPAGE = "https://github.com/discogs/discogs_client"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=13;endline=13;md5=689af13eac0d87fff15d75e7e480e9a0"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "cc979fcbb5283f74d388c7111c8ed6bef920b01614a014d6b1c5d6fbb554bfc3"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-requests \
    python3-six \
    python3-oauthlib \
"
