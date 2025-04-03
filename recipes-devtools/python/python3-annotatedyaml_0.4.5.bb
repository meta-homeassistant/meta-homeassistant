SUMMARY = "Annotated YAML that supports secrets for Python"
HOMEPAGE = "https://github.com/home-assistant-libs/annotatedyaml"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=76a9bfd317d9fbffd2807de292360954"

SRC_URI[sha256sum] = "e251929cd7e741fa2e9ece13e24e29bb8f1b5c6ca3a9ef7292a66a3ae8b9390f"

inherit pypi python_poetry_core cython

PYPI_PACKAGE = "annotatedyaml"

RDEPENDS:${PN} = "\
    python3-propcache (>=0.1) \
    python3-pyyaml (>=6.0.1) \
    python3-voluptuous (>=0.15) \
"
