DESCRIPTION = "End-to-End encryption with SNI proxy on top of a TCP multiplexer."
HOMEPAGE = "https://github.com/NabuCasa/snitun"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

inherit pypi setuptools3

SRC_URI[sha256sum] = "a51b4331acb77d72e6f9d6d34a9721d9411d09c804d75abbbccceb76d90076d1"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-attrs (>=18.2.0) \
    ${PYTHON_PN}-async-timeout (>=3.0.1) \
    ${PYTHON_PN}-cryptography (>=2.5) \
"
