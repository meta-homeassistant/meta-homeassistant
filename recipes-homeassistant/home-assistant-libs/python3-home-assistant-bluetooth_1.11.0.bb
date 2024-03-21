SUMMARY = "Basic bluetooth models used by Home Assistant."
HOMEPAGE = "https://github.com/home-assistant-libs/home-assistant-bluetooth"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"

PYPI_PACKAGE = "home_assistant_bluetooth"

inherit pypi python_poetry_core

SRC_URI[sha256sum] = "75cc805917be2f7cad56bf19b7b2947d58c3919650634154e068f15b320f303d"

RDEPENDS:${PN} = "\
    python3-core (>=3.10) \
    python3-habluetooth (>=0.11.0) \
"
