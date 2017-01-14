SUMMARY = "Google API Client Library for Python"
HOMEPAGE = "http://github.com/google/google-api-python-client/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=94023d14f6b58272fd885e4e3f2f08b3"

inherit pypi

SRC_URI[md5sum] = "d09c91810b7bb0e1042307266902eec4"
SRC_URI[sha256sum] = "1b161de2de3900e5faef55c4ed73a9f7c3303b229d2dc9c55b6caea1f09e9fb4"

RDEPENDS_${PN}_class-target += " \
    ${PYTHON_PN}-uritemplate \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-oauth2client \
    ${PYTHON_PN}-httplib2 \
"
