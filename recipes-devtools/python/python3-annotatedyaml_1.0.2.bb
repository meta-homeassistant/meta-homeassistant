SUMMARY = "Annotated YAML that supports secrets for Python"
HOMEPAGE = "https://github.com/home-assistant-libs/annotatedyaml"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=76a9bfd317d9fbffd2807de292360954"

SRC_URI[sha256sum] = "f9a49952994ef1952ca17d27bb6478342eb1189d2c28e4c0ddbbb32065471fb0"

inherit pypi python_poetry_core cython

PYPI_PACKAGE = "annotatedyaml"

RDEPENDS:${PN} = "\
    python3-propcache (>=0.1) \
    python3-pyyaml (>=6.0.1) \
    python3-voluptuous (>=0.15) \
"
