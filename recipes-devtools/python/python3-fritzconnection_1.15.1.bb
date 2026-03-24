SUMMARY = "Python-Tool to communicate with the AVM Fritz!Box by the TR-064 protocol and the AHA-HTTP-Interface"
HOMEPAGE = "https://github.com/kbr/fritzconnection"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=14e77f0736b95df3d3544d00d4894342"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "aa40b0a850f65fd7ea0483e65f733aa534d63c5e5bb9a8306c63e9dfd0bcf5dd"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    python3-requests (>=2.22.0) \
    python3-segno (>=1.4.1) \
"
