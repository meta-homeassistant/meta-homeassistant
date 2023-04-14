SUMMARY = "A Python Slugify application that handles Unicode"
HOMEPAGE = "https://github.com/un33k/python-slugify"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7946d011d653bfcfbb24480377867128"

PYPI_PACKAGE = "python-slugify"

inherit setuptools3 pypi

SRC_URI[md5sum] = "9725b833e9d537066890063a8a8e604b"
SRC_URI[sha256sum] = "69a517766e00c1268e5bbfc0d010a0a8508de0b18d30ad5a1ff357f8ae724270"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-pycryptodome (>=3.3.1) \
    ${PYTHON_PN}-six (<2.0) \
    ${PYTHON_PN}-ecdsa (<1.0) \
    ${PYTHON_PN}-future (<1.0) \
    ${PYTHON_PN}-text-unidecode (>=1.2) \
"
