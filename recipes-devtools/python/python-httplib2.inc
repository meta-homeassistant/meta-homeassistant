SUMMARY = "A comprehensive HTTP client library, httplib2 supports many features left out of other HTTP libraries."
HOMEPAGE = "https://github.com/jcgregorio/httplib2"
LICENSE = "MIT"
# TODO: Use correct file once: https://github.com/jcgregorio/httplib2/issues/332 is fixed
#LIC_FILES_CHKSUM = "file://LICENSE;md5=3f056150ac7fad21b51033a5e4ad0031"
LIC_FILES_CHKSUM = "file://setup.cfg;md5=d86758afb08a60bc589dc67bfea670b2"

inherit pypi

SRC_URI[md5sum] = "bd1b1445b3b2dfa7276b09b1a07b7f0e"
SRC_URI[sha256sum] = "c3aba1c9539711551f4d83e857b316b5134a1c4ddce98a875b7027be7dd6d988"

do_install_append () {
    # Files in the tarball are not world readable
    chmod -R a+r ${D}${libdir}
}
