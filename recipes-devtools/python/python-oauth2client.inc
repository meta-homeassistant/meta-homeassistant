SUMMARY = "OAuth 2.0 client library"
HOMEPAGE = "http://github.com/google/oauth2client/"
LICENSE = "Apache-2.0"
#TODO: Use correct file once is fixed: https://github.com/google/oauth2client/issues/693
#LIC_FILES_CHKSUM = "file://LICENSE;md5=d7dba1721bc8ce05d421f7279cb87971"
LIC_FILES_CHKSUM = "file://setup.cfg;md5=c7944671b56b57941659d2e5928422bb"

inherit pypi

SRC_URI[md5sum] = "7969836a49e6743ecd746997b2025926"
SRC_URI[sha256sum] = "80be5420889694634b8517b4acd3292ace881d9d1aa9d590d37ec52faec238c7"

RDEPENDS_${PN}_class-target = " \
    ${PYTHON_PN}-httplib2 \
    ${PYTHON_PN}-pyasn1 \
    ${PYTHON_PN}-pyasn1-modules \
    ${PYTHON_PN}-rsa \
    ${PYTHON_PN}-six \
    "
