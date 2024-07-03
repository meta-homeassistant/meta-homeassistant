SUMMARY = "A tool for generating OIDC identities"
HOMEPAGE = "https://pypi.org/project/id/"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[sha256sum] = "23c06772e8bd3e3a44ee3f167868bf5a8e385b0c1e2cc707ad36eb7486b4765b"

inherit pypi python_flit_core

PYPI_PACKAGE = "id"
RDEPENDS:${PN} = "\
    python3-pydantic \
    python3-requests \
"
