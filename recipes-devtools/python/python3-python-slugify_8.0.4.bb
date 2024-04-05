SUMMARY = "A Python Slugify application that handles Unicode"
HOMEPAGE = "https://github.com/un33k/python-slugify"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7946d011d653bfcfbb24480377867128"

PYPI_PACKAGE = "python-slugify"

inherit setuptools3 pypi

SRC_URI[sha256sum] = "59202371d1d05b54a9e7720c5e038f928f45daaffe41dd10822f3907b937c856"

RDEPENDS:${PN} = "\
    python3-text-unidecode (>=1.3) \
"
