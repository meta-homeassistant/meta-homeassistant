SUMMARY = "A Python Slugify application that handles Unicode"
HOMEPAGE = "https://github.com/un33k/python-slugify"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7946d011d653bfcfbb24480377867128"

PYPI_PACKAGE = "python-slugify"

inherit pypi

SRC_URI[md5sum] = "338fce77bd0dc033c0042a3417ea27a0"
SRC_URI[sha256sum] = "a9f468227cb11e20e251670d78e1b5f6b0b15dd37bbd5c9814a25a904e44ff66"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-pycryptodome (>=3.3.1) \
    ${PYTHON_PN}-six (<2.0) \
    ${PYTHON_PN}-ecdsa (<1.0) \
    ${PYTHON_PN}-future (<1.0) \
    ${PYTHON_PN}-text-unidecode (>=1.2) \
"
