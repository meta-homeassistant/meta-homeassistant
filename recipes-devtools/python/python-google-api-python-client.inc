SUMMARY = "Google API Client Library for Python"
HOMEPAGE = "http://github.com/google/google-api-python-client/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=94023d14f6b58272fd885e4e3f2f08b3"

inherit pypi

SRC_URI[md5sum] = "d2485fd185d3f8ce1379da12aa1f20f0"
SRC_URI[sha256sum] = "bb1f27740f6596f8272a2e1033d93d68e27e8ed5d22d6ab957e3f1d3f8ce05f6"

RDEPENDS_${PN}_class-target += " \
    ${PYTHON_PN}-uritemplate \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-oauth2client \
    ${PYTHON_PN}-httplib2 \
"
