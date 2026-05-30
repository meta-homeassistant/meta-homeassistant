SUMMARY = "Mozart platform API"
HOMEPAGE = "https://github.com/bang-olufsen/mozart-open-api"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=da8c5ff82c5bd7705d518966865aba9b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "8a55121a07389ba88c054b9223baadedce03004f1c38f4f32c6790e0940007c5"

inherit pypi python_poetry_core

PYPI_PACKAGE = "mozart_api"

RDEPENDS:${PN} = "\
    python3-urllib3 (>= 1.25.3) \
    python3-dateutil (>= 2.8.2) \
    python3-aiohttp (>= 3.11.0) \
    python3-pydantic (>= 1.10) \
    python3-aenum (>= 3.1.11) \
    python3-aioconsole (>= 0.4.1) \
    python3-inflection (>= 0.5.1) \
    python3-typing-extensions (>= 4.7.1) \
    python3-zeroconf (>= 0.25.1) \
"
