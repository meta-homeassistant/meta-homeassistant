SUMMARY = "Python Library to access AVM Fritz!Box homeautomation"
HOMEPAGE = "https://github.com/hthiery/python-fritzhome"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=01351c51c0264f1a06fee66797afb35a"

SRC_URI[sha256sum] = "7d92a8803f95ccbfb6476211a98715d9a943cd23f78b87e38cdb7d90358daa59"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    python3-requests \
    python3-cryptography \
"
