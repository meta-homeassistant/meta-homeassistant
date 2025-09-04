SUMMARY = "A Server-Sent Event python client base on aiohttp"
HOMEPAGE = "https://github.com/JelleZijlstra/aiohttp-sse-client2"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4c3fcfae24247cb8bd2a0782906c3fbc"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com"

SRC_URI += "file://0001-Make-PEP517-compliant.patch"
SRC_URI[sha256sum] = "5cdd33fc0d034aea339e190726bb918bc61fd3424c7ab528d07b1d60790a979f"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3) \
    python3-attrs \
    python3-multidict \
    python3-yarl \
"

PYPI_PACKAGE = "aiohttp-sse-client2"
