SUMMARY = "Voluptuous is a Python data validation library"
HOMEPAGE = "https://github.com/alecthomas/voluptuous"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=9855ba150f2edb00d8e7a41554896ffb"

inherit pypi setuptools3

SRC_URI[md5sum] = "78d39d2a15e3717ab8d100944da60d11"
SRC_URI[sha256sum] = "e8d31c20601d6773cb14d4c0f42aee29c6821bbd1018039aac7ac5605b489723"

do_install:append () {
    # Files in the tarball are not world readable
    chmod -R a+r ${D}${libdir}
}
