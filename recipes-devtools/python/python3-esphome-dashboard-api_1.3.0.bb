SUMMARY = "API to interact with ESPHome Dashboard"
HOMEPAGE = "https://github.com/esphome/dashboard-api"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5a588bcbe30e4d6b149fa57244eede5e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "798c9d92046c97b278207f10e400ecf19b0944e50dcfd316bcbadb407ce71189"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "esphome_dashboard_api"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
RDEPENDS:${PN} = "python3-aiohttp python3-orjson"
