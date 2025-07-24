SUMMARY = "A Blink camera Python Library."
HOMEPAGE = "https://github.com/fronzbot/blinkpy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=de42c83a8a623a54d153a06063f64c9a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-relax-build-tool-req.patch"
SRC_URI[sha256sum] = "62d9267bef36eca8ab9d08e37f12849664d63de23c4926a8ea6a127ede7b2114"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = " \
    python3-dateutil (>=2.8.1) \
    python3-requests (>=2.24.0) \
    python3-python-slugify (>=4.0.1) \
    python3-sortedcontainers (>=2.4.0) \
    python3-aiohttp (>=3.8.4) \
    python3-aiofiles (>=23.1.0) \
"

PYPI_PACKAGE = "blinkpy"
