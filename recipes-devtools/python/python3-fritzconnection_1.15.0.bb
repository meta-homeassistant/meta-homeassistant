SUMMARY = "Python-Tool to communicate with the AVM Fritz!Box by the TR-064 protocol and the AHA-HTTP-Interface"
HOMEPAGE = "https://github.com/kbr/fritzconnection"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=14e77f0736b95df3d3544d00d4894342"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "56b7194e137a88a67fd4f622c05fa791a0b5f452e33825c3737ac8bf78198feb"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    python3-requests (>=2.22.0) \
"
