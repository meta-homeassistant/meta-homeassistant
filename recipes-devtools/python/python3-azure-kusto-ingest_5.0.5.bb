SUMMARY = "Kusto Ingest Client"
HOMEPAGE = "https://github.com/Azure/azure-kusto-python"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-add-missing-init-file.patch"
SRC_URI[sha256sum] = "507aee19303fa947194094ec5c9161c562458a7e6495565968953a2d7cb33bbc"

inherit pypi setuptools3

#PACKAGECONFIG ?= "pandas"
PACKAGECONFIG[pandas] = ",,,python3-pandas"

RDEPENDS:${PN} += "\
    python3-azure-kusto-data (>=5.0.5) \
    python3-azure-storage-blob (>=12.23.0) \
    python3-azure-storage-queue (>=12.12.0) \
    python3-tenacity (>=8.0.0) \
"

PYPI_PACKAGE = "azure-kusto-ingest"
