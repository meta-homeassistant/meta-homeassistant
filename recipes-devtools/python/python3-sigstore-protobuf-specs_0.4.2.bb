SUMMARY = "A library for serializing and deserializing Sigstore messages"
HOMEPAGE = "https://github.com/sigstore/protobuf-specs"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "9038a5562de33453e18aa049205070592f80e7619618cf3edb2e84ce535a44b8"

inherit pypi python_flit_core

PYPI_PACKAGE = "sigstore_protobuf_specs"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-betterproto (=2.0.0b6) \
"
