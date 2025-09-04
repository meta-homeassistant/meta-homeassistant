SUMMARY = "asyncio client for the Awair GraphQL and Local APIs"
HOMEPAGE = "https://github.com/ahayworth/python_awair"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=13d62c9057b7674e34fe1cbde1b36c2f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b48eb04585191531a943a8da5fca7744805ea71ec3187f6470befc36a206bdb6"

inherit pypi python_poetry_core

PYPI_PACKAGE = "python-awair"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.6.1) \
    python3-voluptuous (>=0.11.7) \
"
