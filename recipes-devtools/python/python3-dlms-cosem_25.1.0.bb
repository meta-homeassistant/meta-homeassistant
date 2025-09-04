SUMMARY = "A Python library for DLMS/COSEM"
HOMEPAGE = "https://github.com/pwitab/dlms-cosem"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=25a7af7c07d944197cd741d316b9f38f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-Fix-compilation-by-removing-ref-to-non-packaged-item.patch"
SRC_URI[sha256sum] = "6f5b746a4ba0163c319eaa67a59a1076a5a8196d5b674e64e647782ecc79e81d"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-asn1crypto (>=1.4.0) \
    python3-attrs (>=22.2.0) \
    python3-cryptography (>=35.0.0) \
    python3-pyserial (>=3.5) \
    python3-dateutil (>=2.8.1) \
    python3-structlog (>=22.1.0) \
    python3-typing-extensions (>=3.10) \
"

RDEPENDS:${PN}-ptest += "python3-pytest python3-pytest-cov python3-pytest-sugar"

PYPI_PACKAGE = "dlms-cosem"
