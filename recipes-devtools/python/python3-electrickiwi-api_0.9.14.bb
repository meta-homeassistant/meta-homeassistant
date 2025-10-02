SUMMARY = "Provide a simple API interface to the Electric Kiwi API and includes all endpoints available on the juice hacker site"
HOMEPAGE = "https://github.com/mikey0000/EK-API"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d539fc2dddbdf63a1e1370f5104325ff"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "078654bd258af18558665ec62f4bc19d15b12c99c883fd55328192b415e91a28"

inherit pypi python_poetry_core

PYPI_PACKAGE = "electrickiwi_api"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
RDEPENDS:${PN} = "python3-aiohttp (>=3.8.1)"
