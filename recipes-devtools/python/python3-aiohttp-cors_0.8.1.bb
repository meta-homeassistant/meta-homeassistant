SUMMARY = "CORS support for aiohttp"
HOMEPAGE = "https://github.com/aio-libs/aiohttp-cors"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=995d66ae531b6ad2bf8bd4b274c9a20a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi setuptools3

SRC_URI[sha256sum] = "ccacf9cb84b64939ea15f859a146af1f662a6b1d68175754a07315e305fb1403"

PYPI_PACKAGE = "aiohttp_cors"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=1.1) \
"
