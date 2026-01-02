SUMMARY = "A python3 library to communicate with Adax"
HOMEPAGE = "https://github.com/Danielhiversen/pyAdaxLocal"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2736a6a8b58491968000c6e0130f0471"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "8c34e21599549d17ba3e6ddc5e806dcbbb879afc5afe256b0d6b933edd83dd6d"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.0.6) \
    python3-async-timeout (>=1.4.0) \
    python3-bleak \
"

PYPI_PACKAGE = "adax_local"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
