SUMMARY = "A better Protobuf / gRPC generator & library"
HOMEPAGE = "https://github.com/danielgtaylor/python-betterproto"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=393474300131412f76a83934dd8a3830"

SRC_URI[sha256sum] = "720ae92697000f6fcf049c69267d957f0871654c8b0d7458906607685daee784"

inherit pypi python_poetry_core

PYPI_PACKAGE = "betterproto"

RDEPENDS:${PN} = "\
    python3-grpclib\
    python3-dateutil \
"
