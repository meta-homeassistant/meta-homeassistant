SUMMARY = "Microsoft Azure Core Library for Python"
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/core/azure-core"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e848d080178fb2d08b67acc5ba80b9fd"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c0be528489485e9ede59b6971eb63c1eaacf83ef53001bfe3904e475e972be5c"

inherit pypi setuptools3 ptest-python-pytest

#PACKAGECONFIG ?= "aio tracing"
PACKAGECONFIG[aio] = ",,,python3-aiohttp"
PACKAGECONFIG[tracing] = ",,,python3-opentelemetry-api~"

RDEPENDS:${PN} += "\
    python3-requests (>=2.21.0) \
    python3-six (>=1.11.0) \
    python3-typing-extensions (>=4.6.0) \
"

PYPI_PACKAGE = "azure_core"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
