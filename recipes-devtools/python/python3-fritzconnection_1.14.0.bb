SUMMARY = "Python-Tool to communicate with the AVM Fritz!Box by the TR-064 protocol and the AHA-HTTP-Interface"
HOMEPAGE = "https://github.com/kbr/fritzconnection"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=14e77f0736b95df3d3544d00d4894342"

SRC_URI[sha256sum] = "95dacaf9bed6b52d809169006c0994bc55cc893dbe0a014bcf9535ae9d00982f"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    python3-requests (>=2.22.0) \
"
