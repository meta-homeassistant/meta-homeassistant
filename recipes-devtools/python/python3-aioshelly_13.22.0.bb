SUMMARY = "Python library to control Shelly"
HOMEPAGE = "https://github.com/home-assistant-libs/aioshelly"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_setuptools_build_meta ptest-python-pytest

SRC_URI[sha256sum] = "f3296bfbc3f908c645863e6f5dbb06444f44d89e7e95ab85c1c464fce9490b75"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.11.1) \
    python3-bluetooth-data-tools (>=1.19.0) \
    python3-core (>=3.11) \
    python3-habluetooth (>=3.22.0) \
    python3-orjson (>=3.8.1) \
"

RDEPENDS:${PN}-ptest:append = " \
    python3-pytest-asyncio \
"
