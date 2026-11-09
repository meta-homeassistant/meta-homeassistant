SUMMARY = "A Blink camera Python Library."
HOMEPAGE = "https://github.com/fronzbot/blinkpy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=de42c83a8a623a54d153a06063f64c9a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-relax-build-tool-req.patch"
SRC_URI[sha256sum] = "4c135a77823e8dcfe72be601c0462326cf1c1725a193506ca638e09bbf4cf1bb"

DEPENDS += "python3-wheel-native"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = " \
    python3-aiofiles (>=23.1.0) \
    python3-aiohttp (>=3.14.1) \
    python3-dateutil (>=2.9.0) \
    python3-python-slugify (>=8.0.4) \
    python3-requests (>=2.34.2) \
    python3-sortedcontainers (>=2.4.0) \
"

RDEPENDS:${PN}-ptest:append = " \
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-pytest-sugar \
    python3-pytest-timeout \
"
