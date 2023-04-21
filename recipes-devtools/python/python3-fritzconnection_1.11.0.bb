SUMMARY = "Python-Tool to communicate with the AVM Fritz!Box by the TR-064 protocol and the AHA-HTTP-Interface"
HOMEPAGE = "https://github.com/kbr/fritzconnection"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=14e77f0736b95df3d3544d00d4894342"

SRC_URI[md5sum] = "1e2b8aa67f6666db4b256efdecabf9f2"
SRC_URI[sha256sum] = "970ea8d6502ba7a9b43472b0bc9470830932535cce9cf2a8b0ff1db9dc13cf74"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-requests (>=2.22.0) \
"
