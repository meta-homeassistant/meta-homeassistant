SUMMARY = "Asynchronous Python client for SmartThings."
HOMEPAGE = "https://github.com/pySmartThings/pysmartthings"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c11f6785f26e567a799a64201e1ce6c3"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "43b2466753d1e016d63e96836b4ec595c35c1341910893bdb739e42b46a0d3ce"

inherit pypi python_poetry_core

PYPI_PACKAGE = "pysmartthings"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-mashumaro (>=3.11) \
    python3-orjson (>=3.9.10) \
    python3-yarl (>=1.6.0) \
    python3-aiohttp-sse-client2 (>=0.3.0) \
"
