SUMMARY = "Async implementation of pyacaia"
HOMEPAGE = "https://github.com/zweckj/aioacaia"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c265ede6bd9c210e338499d3b8efc0c6faf60bce5c14284d0b1f3217d24adbfa"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "python3-bleak (>=0.20.2)"

PYPI_PACKAGE = "aioacaia"
