SUMMARY = "Microsoft Azure Identity Library for Python"
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/identity/azure-identity"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e848d080178fb2d08b67acc5ba80b9fd"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "226c1ef982a9f8d5dcf6e0f9ed35eaef2a4d971e7dd86317e9b9d52e70a035e4"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-azure-core (>=1.31.0) \
    python3-cryptography (>=2.5) \
    python3-msal (>=1.30.0) \
    python3-msal-extensions (>=1.2.0) \
    python3-typing-extensions (>=4.0.0) \
"

PYPI_PACKAGE = "azure_identity"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
