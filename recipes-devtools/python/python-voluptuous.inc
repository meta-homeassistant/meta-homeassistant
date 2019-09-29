SUMMARY = "Voluptuous is a Python data validation library"
HOMEPAGE = "https://github.com/alecthomas/voluptuous"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=9855ba150f2edb00d8e7a41554896ffb"

inherit pypi

SRC_URI[md5sum] = "695928b25384deba7c3d5e4de3520ab1"
SRC_URI[sha256sum] = "2abc341dbc740c5e2302c7f9b8e2e243194fb4772585b991931cb5b22e9bf456"

do_install_append () {
    # Files in the tarball are not world readable
    chmod -R a+r ${D}${libdir}
}
