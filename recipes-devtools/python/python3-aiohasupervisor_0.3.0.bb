SUMMARY = "Asynchronous python client for Home Assistant Supervisor."
HOMEPAGE = "https://github.com/home-assistant-libs/python-supervisor-client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-relax-setuptools-req.patch"
SRC_URI[sha256sum] = "91bf0b051f28582196f900a31c9bcbebec6de9e3ed1a32a2947a892c04748ce2"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "aiohasupervisor"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.3.0) \
    python3-mashumaro (>=3.11) \
    python3-orjson (>=3.6.1) \
    python3-yarl (>=1.6.0) \
"
