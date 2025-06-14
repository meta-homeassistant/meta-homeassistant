SUMMARY = "A run function for asyncio-based apps that does all the boilerplate."
HOMEPAGE = "https://github.com/cjrh/aiorun"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e3fc50a88d0a364313df4b21ef20c29e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "86d1075a034ce2671ab532db06e9204fe784cdd0c66ca7b8cc47a7527d0d50a3"

inherit pypi python_flit_core ptest-python-pytest

PYPI_PACKAGE = "aiorun"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-cov \
"
