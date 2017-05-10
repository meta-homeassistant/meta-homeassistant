SUMMARY = "Voluptuous is a Python data validation library"
HOMEPAGE = "https://github.com/alecthomas/voluptuous"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=9855ba150f2edb00d8e7a41554896ffb"

inherit pypi

SRC_URI[md5sum] = "e3fc99b75618d384cad63bc71b6507bc"
SRC_URI[sha256sum] = "7a7466f8dc3666a292d186d1d871a47bf2120836ccb900d5ba904674957a2396"

do_install_append () {
    # Files in the tarball are not world readable
    chmod -R a+r ${D}${libdir}
}
