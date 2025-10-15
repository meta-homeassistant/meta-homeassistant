SUMMARY = "Asynchronous Python client for getting forecast solar information"
HOMEPAGE = "https://github.com/home-assistant-libs/forecast_solar"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=410b79927821a94f096acb8f508f5117"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "01fd678b5213c220d23c042413deb2c992359d31a1bce319737454e38ef36211"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-yarl (>=1.6.0) \
"

PYPI_PACKAGE = "forecast_solar"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
