SUMMARY = "Python API for Ayla IoT products"
HOMEPAGE = "https://github.com/rewardone/ayla-iot-unofficial"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=685dda0c92b16f886457366fc1c6a8b7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "541b1bfaf469b27ea6720becb60796652f4ae872986c3cb5f75764d3e61d088f"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.8.4) \
    python3-requests (>=2.31.0) \
    python3-ujson (>=5.8.0) \
"

PYPI_PACKAGE = "ayla_iot_unofficial"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
