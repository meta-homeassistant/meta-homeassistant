SUMMARY = "Async implementation of pyacaia"
HOMEPAGE = "https://github.com/zweckj/aioacaia"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "327e887f517682c1e7e82d67ec9c87304c8e980e39c461c6cf3db6152ee8bed4"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "python3-bleak (>=0.20.2)"

PYPI_PACKAGE = "aioacaia"
