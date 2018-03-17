SUMMARY = "A library to identify devices (phones, tablets) and their capabilities by parsing (browser/HTTP) user agent strings"
HOMEPAGE = "https://github.com/selwin/python-user-agents"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b3645b4ad6bca318833557c926dd13af"

inherit pypi setuptools3

SRC_URI[md5sum] = "0f18f7edf132605d1d43cc56d4850c31"
SRC_URI[sha256sum] = "643d16772280052b546d956971d719989ef6dc9b17d9ff0386aa21391a038039"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-ua-parser \
    "
