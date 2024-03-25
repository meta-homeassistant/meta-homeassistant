SUMMARY = "A Python Slugify application that handles Unicode"
HOMEPAGE = "https://github.com/un33k/python-slugify"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7946d011d653bfcfbb24480377867128"

PYPI_PACKAGE = "python-slugify"

inherit setuptools3 pypi

SRC_URI[sha256sum] = "ce0d46ddb668b3be82f4ed5e503dbc33dd815d83e2eb6824211310d3fb172a27"

RDEPENDS:${PN} = "\
    python3-text-unidecode (>=1.3) \
"
