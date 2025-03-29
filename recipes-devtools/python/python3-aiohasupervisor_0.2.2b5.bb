SUMMARY = "Asynchronous python client for Home Assistant Supervisor."
HOMEPAGE = "https://github.com/home-assistant-libs/python-supervisor-client"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-relax-setuptools-req.patch"
SRC_URI[sha256sum] = "10556147b2fed525735cee14a43ad703512e3dd79ec39e42578ca43b72b90452"
SRCREV = "51a8a78e82bac3fc816fabb7ffcc1b53232552ba"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "aiohasupervisor"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.3.0) \
    python3-mashumaro (>=3.11) \
    python3-orjson (>=3.6.1) \
    python3-yarl (>=1.6.0) \
"
