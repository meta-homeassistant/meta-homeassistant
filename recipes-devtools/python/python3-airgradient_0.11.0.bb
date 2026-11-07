SUMMARY = "Asynchronous Python client for AirGradient."
HOMEPAGE = "https://github.com/airgradienthq/python-airgradient"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=3cbad2730435ed9eb7dd28aa6f638767"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "960fb0864bd4c9e618c9c7ae63a4397a862fe0fc89b1393f82f5a25d2385b119"

inherit pypi python_poetry_core


RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-mashumaro (>=3.11) \
    python3-orjson (>=3.9.0) \
    python3-yarl (>=1.6.0) \
"
