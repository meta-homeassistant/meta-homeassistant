SUMMARY = "Microsoft Azure Event Hubs Client Library for Python"
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/eventhub/azure-eventhub"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee51f94efd0db5b258b5b1b8107fea02"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c22d508b95977edbdbc844d693b9f5403b2c4e4ca075ac38d8dcb5657aba6e89"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-azure-core (>=1.27.0) \
    python3-typing-extensions (>=4.0.1) \
"

PYPI_PACKAGE = "azure_eventhub"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
