SUMMARY = "A library for serializing and deserializing Sigstore messages"
HOMEPAGE = "https://github.com/sigstore/protobuf-specs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI[sha256sum] = "cae041b40502600b8a633f43c257695d0222a94efa1e5110a7ec7ada78c39d99"

inherit pypi python_flit_core

PYPI_PACKAGE = "sigstore_protobuf_specs"

RDEPENDS:${PN} = "\
    python3-betterproto (=2.0.0b6) \
"
