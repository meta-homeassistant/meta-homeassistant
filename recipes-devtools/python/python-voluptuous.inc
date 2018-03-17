SUMMARY = "Voluptuous is a Python data validation library"
HOMEPAGE = "https://github.com/alecthomas/voluptuous"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=9855ba150f2edb00d8e7a41554896ffb"

inherit pypi

SRC_URI[md5sum] = "6acb0a6f8413a5cc1e194adb0c62420b"
SRC_URI[sha256sum] = "af7315c9fa99e0bfd195a21106c82c81619b42f0bd9b6e287b797c6b6b6a9918"

do_install_append () {
    # Files in the tarball are not world readable
    chmod -R a+r ${D}${libdir}
}
