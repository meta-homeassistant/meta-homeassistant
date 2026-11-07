SUMMARY = "Python module for handling audio metadata"
HOMEPAGE = "https://github.com/quodlibet/mutagen"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta ptest-python-pytest

SRC_URI[sha256sum] = "8f95637ab9f6f305cec6bd1294e197debe207998e3e068596563c74f86b0a173"

RDEPENDS:${PN} += "\
    python3-core (>=3.7) \
"

RDEPENDS:${PN}-ptest += "\
    python3-hypothesis \
"
