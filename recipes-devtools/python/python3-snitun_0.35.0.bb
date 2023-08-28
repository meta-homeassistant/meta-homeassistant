DESCRIPTION = "End-to-End encryption with SNI proxy on top of a TCP multiplexer."
HOMEPAGE = "https://github.com/NabuCasa/snitun"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit pypi setuptools3

SRC_URI[sha256sum] = "cb32bacc55c73c68d2285e9d1f43b096238901fd0ff72c03f26e1c01e1fbd84f"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-attrs (>=18.2.0) \
    ${PYTHON_PN}-async-timeout (>=3.0.1) \
    ${PYTHON_PN}-cryptography (>=2.5) \
"
