SUMMARY = "Basic bluetooth models used by Home Assistant."
HOMEPAGE = "https://github.com/home-assistant-libs/home-assistant-bluetooth"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRCREV = "d4fd8a5fcad393c10f6c7472d93e996f0a0c31ba"

inherit pypi python_poetry_core ptest

SRC_URI[sha256sum] = "9cac369fea11f67c1165df527f918a8c56630cbccb3c5cbe24b72f06aeb9f59b"

RDEPENDS:${PN} = "\
    python3-core (>=3.11) \
    python3-habluetooth (>=3.0) \
"

PYPI_PACKAGE = "home_assistant_bluetooth"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
