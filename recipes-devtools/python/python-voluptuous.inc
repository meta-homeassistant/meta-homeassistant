SUMMARY = "Voluptuous is a Python data validation library"
HOMEPAGE = "https://github.com/alecthomas/voluptuous"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=9855ba150f2edb00d8e7a41554896ffb"

inherit pypi

SRC_URI[md5sum] = "3dfccea158f4d48c1b7ad23d48eabb6e"
SRC_URI[sha256sum] = "ed5a11fda273754caabb6becd5fe172ee2621cd2c8ff8279433173bb7b0ec568"

do_install_append () {
    # Files in the tarball are not world readable
    chmod -R a+r ${D}${libdir}
}
