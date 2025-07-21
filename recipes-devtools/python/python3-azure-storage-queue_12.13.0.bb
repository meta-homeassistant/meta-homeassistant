SUMMARY = "Microsoft Azure Azure Queue Storage Client Library for Python"
HOMEPAGE = "https://github.com/Azure/azure-sdk-for-python/tree/main/sdk/storage/azure-storage-queue"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ee51f94efd0db5b258b5b1b8107fea02"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "25691e7958d24970392451134dfa547637fd2dfcfde5b3476a2e152e56973f8c"

inherit pypi setuptools3 ptest-python-pytest

#PACKAGECONFIG ?= "aio"
PACKAGECONFIG[aio] = ",,,python3-azure-core[aio]"

RDEPENDS:${PN} += "\
    python3-azure-core (>=1.30.0) \
    python3-cryptography (>=2.1.4) \
    python3-isodate (>=0.6.1) \
    python3-typing-extensions (>=4.6.0) \
"

PYPI_PACKAGE = "azure_storage_queue"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
