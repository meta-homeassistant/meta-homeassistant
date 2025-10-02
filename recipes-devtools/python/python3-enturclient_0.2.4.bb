SUMMARY = "An API client for public transport data from Entur."
HOMEPAGE = "https://github.com/hfurubotten/enturclient"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=14618f06888ffbcbcda648497655cdc6"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "1832afc4f98310c92e74ea1f156451bd232d98c14cc40f1327a911cb93bb0411"

inherit pypi python_poetry_core ptest-python-pytest

PYPI_PACKAGE = "enturclient"
RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.7.4) \
    python3-async-timeout (>=3.0.1) \
"

RDEPENDS:${PN}-ptest = "\
    python3-asynctest \
"
