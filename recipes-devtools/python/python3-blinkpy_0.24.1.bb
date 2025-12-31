SUMMARY = "A Blink camera Python Library."
HOMEPAGE = "https://github.com/fronzbot/blinkpy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=de42c83a8a623a54d153a06063f64c9a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-relax-build-tool-req.patch"
SRC_URI[sha256sum] = "07ae4fc576b537d88b9394bbc9ff460f808fd40b7c39818508dd3a9e1923b398"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = " \
    python3-dateutil (>=2.8.1) \
    python3-requests (>=2.24.0) \
    python3-python-slugify (>=4.0.1) \
    python3-sortedcontainers (>=2.4.0) \
    python3-aiohttp (>=3.8.4) \
    python3-aiofiles (>=23.1.0) \
"

RDEPENDS:${PN}-ptest:append = "\
    python3-pytest-cov \
    python3-pytest-sugar \
    python3-pytest-timeout \
    python3-pytest-asyncio \
"

PYPI_PACKAGE = "blinkpy"
