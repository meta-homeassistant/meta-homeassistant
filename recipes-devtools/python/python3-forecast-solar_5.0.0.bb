SUMMARY = "Asynchronous Python client for getting forecast solar information"
HOMEPAGE = "https://github.com/home-assistant-libs/forecast_solar"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b32893bb58475a5fc11ecaf8f9fe064"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "55409b91d3d06b9c1bf28be492f9790cccb7e3c6e3407acf31b3fd96b24ad387"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-yarl (>=1.6.0) \
"

PYPI_PACKAGE = "forecast_solar"
