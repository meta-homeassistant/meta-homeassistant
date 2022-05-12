HOMEPAGE = "https://github.com/closeio/ciso8601"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=650b6b7ede4fbd14ab012aceb71d69d7"

inherit pypi setuptools3

SRC_URI[sha256sum] = "14ad817ed31a698372d42afa81b0173d71cd1d0b48b7499a2da2a01dcc8695e6"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-pytz (>=2019.03) \
"
