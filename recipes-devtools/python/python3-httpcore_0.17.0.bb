SUMMARY = "A minimal HTTP client"
HOMEPAGE = "https://github.com/encode/httpcore"
LICENSE = "BSD-3"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=1c1f23b073da202e1f4f9e426490210c"

SRC_URI[md5sum] = "881211271c5fea2aba9e97dc0e7747e8"
SRC_URI[sha256sum] = "cc045a3241afbf60ce056202301b4d8b6af08845e3294055eb26b09913ef903c"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-anyio (>=3.0) \
    ${PYTHON_PN}-certifi \
    ${PYTHON_PN}-h11 (>=0.13) \
    ${PYTHON_PN}-sniffio (>=1.0.0) \
"
