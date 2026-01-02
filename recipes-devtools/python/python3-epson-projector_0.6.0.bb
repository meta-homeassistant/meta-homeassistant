SUMMARY = "Epson projector support for Python"
HOMEPAGE = "https://github.com/pszafer/epson_projector"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=12a8965e31d96ba989d4294f1e2cd525"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "ffd35cdf13b19d715f4ec4bcb3cdcc5d3915021a8bc2b2a799f47f13ceecf819"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.3.0) \
    python3-async-timeout (>=3.0.0) \
    python3-pyserial-asyncio (>=0.4) \
"

PYPI_PACKAGE = "epson_projector"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
