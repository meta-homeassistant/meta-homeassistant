SUMMARY = "Python Library to access AVM Fritz!Box homeautomation"
HOMEPAGE = "https://github.com/hthiery/python-fritzhome"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=01351c51c0264f1a06fee66797afb35a"

SRC_URI[sha256sum] = "fd411a563b056ca73a89226070c9e463a1026a914ed5cd59c06232c63ec9b605"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-requests \
"
