SUMMARY = "A Python library for controlling YeeLight RGB bulbs"
HOMEPAGE = "https://gitlab.com/stavros/python-yeelight/"
LICENSE = "BSD"
SRCNAME = "yeelight"

LIC_FILES_CHKSUM = "file://LICENSE;md5=d42d2a79677231c7cf556f39656b4046"

inherit pypi

SRC_URI[md5sum] = "1b4246a2bd24ccfe313b5d11ee353ccd"
SRC_URI[sha256sum] = "e7c4307b775d42e7013b117235828efbc468eebde34ca49c66984b80d30cf2df"

RDEPENDS_${PN} = "\
"
