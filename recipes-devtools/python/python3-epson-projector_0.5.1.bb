SUMMARY = "Epson projector support for Python"
HOMEPAGE = "https://github.com/pszafer/epson_projector"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=12a8965e31d96ba989d4294f1e2cd525"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "2f0b1d32ec2f2e27c83f53d13617cb8b84d3651a7f730f4171fe7bbebb0dadb2"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.3.0) \
    python3-async-timeout (>=3.0.0) \
    python3-pyserial-asyncio (>=0.4) \
"

PYPI_PACKAGE = "epson_projector"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
