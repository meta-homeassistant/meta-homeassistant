SUMMARY = "Portable network interface information"
HOMEPAGE = "https://bitbucket.org/al45tair/netifaces"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README.rst;beginline=170;endline=188;md5=ecebc446d7c2ab8c1595b163500c7c6f"

inherit pypi

SRC_URI[md5sum] = "1d424cb5ef52907c5ab913011122a98b"
SRC_URI[sha256sum] = "0c4da523f36d36f1ef92ee183f2512f3ceb9a9d2a45f7d19cda5a42c6689ebe0"

# This is needed otherwise it will error out with a pthread_cancel error.
# TODO: Why is this not detected automatically?
RDEPENDS_${PN} += "libgcc"
