SUMMARY = "Pure-Python RSA implementation"
HOMEPAGE = "https://stuvel.eu/rsa"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c403f6882d4f97a9cd927df987d55634"

inherit pypi

SRC_URI[md5sum] = "b315f47882c24030ee6b5aad628cccdb"
SRC_URI[sha256sum] = "25df4e10c263fb88b5ace923dd84bf9aa7f5019687b5e55382ffcdb8bede9db5"

RDEPENDS_${PN}_class-target += " \
    ${PYTHON_PN}-pyasn1 \
"

BBCLASSEXTEND = "native nativesdk"
