SUMMARY = "Python wrapper for zwave-js-server"
HOMEPAGE = "https://github.com/home-assistant-libs/zwave-js-server-python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "ccd8994e9fbcddfc9afa5bad0acb809734440104685f673ee6769c628bc7fe98"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "zwave_js_server_python"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-aiohttp (>3) \
    python3-pydantic (>=1.10.0) \
"
