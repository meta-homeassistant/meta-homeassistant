SUMMARY = "Portable network interface information"
HOMEPAGE = "https://bitbucket.org/al45tair/netifaces"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README.rst;beginline=167;endline=186;md5=3f056150ac7fad21b51033a5e4ad0031"

inherit pypi

SRC_URI[md5sum] = "5b4d1f1310ed279e6df27ef3a9b71519"
SRC_URI[sha256sum] = "59d8ad52dd3116fcb6635e175751b250dc783fb011adba539558bd764e5d628b"

# This is needed otherwise it will error out with a pthread_cancel error.
# TODO: Why is this not detected automatically?
RDEPENDS_${PN} += "libgcc"
