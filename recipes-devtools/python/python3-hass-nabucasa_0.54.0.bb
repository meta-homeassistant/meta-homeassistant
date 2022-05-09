HOMEPAGE = "https://www.nabucasa.com/"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8ce93f51d70fd2b9add4f5b93af43d4a"

inherit pypi setuptools3

SRC_URI[md5sum] = "680bbfff1ecd316ac0d6e79ac6ecc04b"
SRC_URI[sha256sum] = "f9e4ee695dc440bf1d8cec9a4ca35fc7054539e68e8fb1571c6f52e64e01f8f5"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-warrant (>=0.6.1) \
    ${PYTHON_PN}-snitun (>=0.18) \
    ${PYTHON_PN}-acme (>=0.32.0) \
    ${PYTHON_PN}-cryptography (>=2.5) \
    ${PYTHON_PN}-attrs (>=18.2.0) \
    ${PYTHON_PN}-pytz \
"
