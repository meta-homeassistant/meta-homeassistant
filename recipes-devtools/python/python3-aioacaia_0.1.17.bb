SUMMARY = "Async implementation of pyacaia"
HOMEPAGE = "https://github.com/zweckj/aioacaia"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=1ebbd3e34237af26da5dc08a4e440464"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "24a2773f0649730e022e9628345f3310911faab1d616534f5e448c175836948a"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "python3-bleak (>=0.20.2)"

PYPI_PACKAGE = "aioacaia"
