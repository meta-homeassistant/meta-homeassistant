SUMMARY = "Python-Tool to communicate with the AVM Fritz!Box by the TR-064 protocol and the AHA-HTTP-Interface"
HOMEPAGE = "https://github.com/kbr/fritzconnection"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=14e77f0736b95df3d3544d00d4894342"

SRC_URI[sha256sum] = "ccc7ff207bb599394dfc19da29c8c54679e318d2b9304f3263a52cb9f4ed33c2"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    python3-requests (>=2.22.0) \
"
