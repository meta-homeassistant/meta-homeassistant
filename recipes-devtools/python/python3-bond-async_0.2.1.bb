SUMMARY = "Asynchronous Python wrapper library over Bond Local API"
HOMEPAGE = "https://github.com/bondhome/bond-async"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c72df95de464049ac53608eb78600a6b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "8ad2452d3d69b5db444de33035629ea4804675150050060197945e765f4e4251"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.6.1) \
    python3-orjson (>=3.8.7) \
"

PYPI_PACKAGE = "bond_async"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
