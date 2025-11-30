SUMMARY = "OAuth 2.0 client library"
HOMEPAGE = "http://github.com/google/oauth2client/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=038e1390e94fe637991fa5569daa62bc"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d486741e451287f69568a4d26d70d9acd73a2bbfa275746c535b4209891cccc6"

inherit pypi ptest-python-pytest setuptools3

RDEPENDS:${PN} += "\
    python3-httplib2 (>=0.9.2) \
    python3-pyasn1 (>=0.1.7) \
    python3-pyasn1-modules (>=0.0.5) \
    python3-rsa (>=3.1.4) \
    python3-six (>=1.6.1) \
"