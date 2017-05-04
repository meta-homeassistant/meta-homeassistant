SUMMARY = "A CoAP (RFC 7252) implementation in C"
HOMEPAGE = "https://github.com/obgm/libcoap/tree/dtls"

LICENSE = "GPL-2.0 | BSD-2-Clause"
LIC_FILES_CHKSUM = "file://COPYING;md5=dd7df0c678b6740ef7874f0c42f7e72e \
					file://LICENSE.BSD;md5=c3ba00f24fff294132e7cca4eea68a6d \
					file://LICENSE.GPL;md5=4641e94ec96f98fabc56ff9cc48be14b"

PV= "4.1.2+git${SRCPV}"
SRCREV = "25863042ae1e95138776f65c772f9fa6ce60495c"
SRC_URI = "gitsm://github.com/obgm/libcoap.git;protocol=https;branch=dtls \
           file://0001-Do-not-install-tinydtls-it-s-only-used-internally.patch"

inherit autotools-brokensep

# Building a shared libary doesn't work at the moment so we only build static
EXTRA_OECONF += "--disable-documentation --disable-shared"

S = "${WORKDIR}/git"

BBCLASSEXTEND = "native"
