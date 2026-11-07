SUMMARY = "A Python3, async-friendly library for Flo by Moen Smart Water Detectors"
HOMEPAGE = "https://github.com/bachya/aioflo"
LICENSE = "MIT"
# Only the copyright year changed (2020 -> 2020-2026).
LIC_FILES_CHKSUM = "file://LICENSE;md5=4c4aa47824a29f1ff834d0506ce481ad"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "fe1b18114fcce556d2e16e741091d8ff0af2087aecc499da0c9156f15beca005"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.14.3) \
"
