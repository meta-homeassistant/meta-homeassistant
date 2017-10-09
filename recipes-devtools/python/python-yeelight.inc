SUMMARY = "A Python library for controlling YeeLight RGB bulbs"
HOMEPAGE = "https://gitlab.com/stavros/python-yeelight/"
LICENSE = "BSD"
SRCNAME = "yeelight"

LIC_FILES_CHKSUM = "file://LICENSE;md5=d42d2a79677231c7cf556f39656b4046"

inherit pypi

SRC_URI[md5sum] = "f72bc1a5afb635c8ece5cb063a69e894"
SRC_URI[sha256sum] = "44458ea326daedd4602be06331773c307872e87cb253e22a3158eddf97b02546"

RDEPENDS_${PN} = "\
"
