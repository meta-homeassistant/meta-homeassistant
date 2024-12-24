SUMMARY = "Async implementation of pyacaia"
HOMEPAGE = "https://github.com/zweckj/aioacaia"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI[sha256sum] = "a6b2ce72cf070e9429bab0c7efddc0b1d2ae5b0ce36b841b5fc957535cf8c437"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "python3-bleak"

PYPI_PACKAGE = "aioacaia"
