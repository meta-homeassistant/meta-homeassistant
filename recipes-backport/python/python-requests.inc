DESCRIPTION = "Python HTTP for Humans."
HOMEPAGE = "http://python-requests.org"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=979d6a23b143e13ea0e5e3aa81248820"

SRC_URI[md5sum] = "4c3c169ed67466088a2a6947784fe444"
SRC_URI[sha256sum] = "a274abba399a23e8713ffd2b5706535ae280ebe2b8069ee6a941cb089440d153"

RDEPENDS_${PN} += " \
    ${PYTHON_PN}-email \
    ${PYTHON_PN}-json \
    ${PYTHON_PN}-ndg-httpsclient \
    ${PYTHON_PN}-netserver \
    ${PYTHON_PN}-pyasn1 \
    ${PYTHON_PN}-pyopenssl \
    ${PYTHON_PN}-pysocks \
    ${PYTHON_PN}-urllib3 \
"

BBCLASSEXTEND = "native nativesdk"
