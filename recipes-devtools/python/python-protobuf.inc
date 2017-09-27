SUMMARY = "Protocol Buffers are Google’s data interchange format"
HOMEPAGE = "https://developers.google.com/protocol-buffers/"
LICENSE = "3-Clause BSD License"
SRCNAME = "protobuf"

LIC_FILES_CHKSUM = "file://setup.py;md5=1fa4ecd360b8c7b33912646032ca988c"

inherit pypi

SRC_URI[md5sum] = "bfc0c61c156a995e909521697e755780"
SRC_URI[sha256sum] = "ef02609ef445987976a3a26bff77119c518e0915c96661c3a3b17856d0ef6374"

RDEPENDS_${PN} = "\
"
