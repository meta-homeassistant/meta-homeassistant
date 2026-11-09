SUMMARY = "Basic bluetooth models used by Home Assistant."
HOMEPAGE = "https://github.com/home-assistant-libs/home-assistant-bluetooth"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_poetry_core ptest

SRC_URI[sha256sum] = "3febd16b194812b156024d9bc8ce8ec7622cdd8d159047cac504cc77ca034ea1"

RDEPENDS:${PN} = "\
    python3-core (>=3.11) \
    python3-habluetooth (>=3.0) \
"
