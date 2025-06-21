SUMMARY = "Python library to control Shelly"
HOMEPAGE = "https://github.com/home-assistant-libs/aioshelly"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit python_setuptools_build_meta ptest-python-pytest

SRC_URI = "git://github.com/home-assistant-libs/aioshelly.git;protocol=https;branch=main"
SRC_URI[sha256sum] = "347c1d5dc1c5f6d2d3f15d04cdad54209cb928251ba46ae4f3e173185f6a13b4"

SRCREV = "ab7f4b7af6cf73d57b51f8459f80480ace559361"

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
