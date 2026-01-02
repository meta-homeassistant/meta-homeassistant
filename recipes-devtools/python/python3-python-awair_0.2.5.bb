SUMMARY = "asyncio client for the Awair GraphQL and Local APIs"
HOMEPAGE = "https://github.com/ahayworth/python_awair"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=13d62c9057b7674e34fe1cbde1b36c2f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "96f54754db6a3c35047bf4539cd76777fb9924d55f677d3d6cec36e2d82dc77f"

inherit pypi python_poetry_core

PYPI_PACKAGE = "python_awair"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.6.1) \
    python3-voluptuous (>=0.11.7) \
"
