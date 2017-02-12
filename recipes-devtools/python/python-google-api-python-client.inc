SUMMARY = "Google API Client Library for Python"
HOMEPAGE = "http://github.com/google/google-api-python-client/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=94023d14f6b58272fd885e4e3f2f08b3"

inherit pypi

SRC_URI[md5sum] = "5efd35416d57e6571276a52f81d26bc7"
SRC_URI[sha256sum] = "8c2f50f8057571a5f817c74820cadb754d47799c5a4ea463c1500fe8e092c1ae"

RDEPENDS_${PN}_class-target += " \
    ${PYTHON_PN}-uritemplate \
    ${PYTHON_PN}-six \
    ${PYTHON_PN}-oauth2client \
    ${PYTHON_PN}-httplib2 \
"
