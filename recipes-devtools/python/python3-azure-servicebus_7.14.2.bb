SUMMARY = "Microsoft Azure Service Bus Client Library for Python"
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee51f94efd0db5b258b5b1b8107fea02"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "4014b7ac882e0d9ff876a3302818607e1a640b93e9d482073d639f5b04266e5c"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-azure-core (>=1.28.0) \
    python3-isodate (>=0.6.0) \
    python3-typing-extensions (>=4.6.0) \
"

PYPI_PACKAGE = "azure_servicebus"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
