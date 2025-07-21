SUMMARY = "JSON (de)serialization, GraphQL and JSON schema generation using Python typing."
HOMEPAGE = "https://github.com/wyfo/apischema"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=57d76440fc5c9183c79d1747d18d2410"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-Relax-build-req.patch"
SRC_URI[sha256sum] = "08a72728b9bc90976b08a3f219f99846fb2f0218cf3dfe2019c5a52fbe1cf1b4"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "apischema"
