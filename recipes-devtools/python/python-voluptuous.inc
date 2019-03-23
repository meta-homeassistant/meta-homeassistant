SUMMARY = "Voluptuous is a Python data validation library"
HOMEPAGE = "https://github.com/alecthomas/voluptuous"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=9855ba150f2edb00d8e7a41554896ffb"

inherit pypi

SRC_URI[md5sum] = "052b52db417a4670c5f0f7387e45ae90"
SRC_URI[sha256sum] = "567a56286ef82a9d7ae0628c5842f65f516abcb496e74f3f59f1d7b28df314ef"

do_install_append () {
    # Files in the tarball are not world readable
    chmod -R a+r ${D}${libdir}
}
