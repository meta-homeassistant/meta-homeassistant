SUMMARY = "Fast ISO8601 date time parser for Python written in C"
HOMEPAGE = "https://github.com/closeio/ciso8601"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=650b6b7ede4fbd14ab012aceb71d69d7"

inherit pypi setuptools3

SRC_URI[sha256sum] = "19e3fbd786d8bec3358eac94d8774d365b694b604fd1789244b87083f66c8900"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-pytz \
"
