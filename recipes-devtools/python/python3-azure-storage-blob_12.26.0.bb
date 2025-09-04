SUMMARY = "Microsoft Azure Blob Storage Client Library for Python"
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/storage/azure-storage-blob"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee51f94efd0db5b258b5b1b8107fea02"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "5dd7d7824224f7de00bfeb032753601c982655173061e242f13be6e26d78d71f"

inherit pypi setuptools3 ptest-python-pytest

#PACKAGECONFIG ?= "aio"
PACKAGECONFIG[aio] = ",,,python3-azure-core[aio]"

RDEPENDS:${PN} += "\
    python3-azure-core (>=1.30.0) \
    python3-cryptography (>=2.1.4) \
    python3-isodate (>=0.6.1) \
    python3-typing-extensions (>=4.6.0) \
"

PYPI_PACKAGE = "azure_storage_blob"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
