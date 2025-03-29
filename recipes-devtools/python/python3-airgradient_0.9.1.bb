SUMMARY = "Asynchronous Python client for AirGradient."
HOMEPAGE = "https://github.com/airgradienthq/python-airgradient"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=3cbad2730435ed9eb7dd28aa6f638767"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "940c816aff82dec35fde11a55ef6e29127302eac0b16aace7947823c935fd39c"

inherit pypi python_poetry_core

PYPI_PACKAGE = "airgradient"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-mashumaro (>=3.11) \
    python3-orjson (>=3.9.0) \
    python3-yarl (>=1.6.0) \
"
