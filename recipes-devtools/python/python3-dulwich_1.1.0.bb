SUMMARY = "Python Git Library"
HOMEPAGE = "https://www.dulwich.io/"
LICENSE = "Apache-2.0 | GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=d45757cfddbd32c1cd3132cf3b444d4f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "9aa855db9fee0a7065ae9ffb38e14e353876d82f17e33e1a1fb3830eb8d0cf43"

inherit pypi python_setuptools_build_meta ptest-python-pytest

DEPENDS += "\
    python3-setuptools-rust-native \
"

PYPI_PACKAGE = "dulwich"
RDEPENDS:${PN} = "\
    python3-urllib3 (>=2.2.2) \
"

RDEPENDS:${PN}-ptest += "\
    python3-gevent \
    python3-wsgiref \
"
