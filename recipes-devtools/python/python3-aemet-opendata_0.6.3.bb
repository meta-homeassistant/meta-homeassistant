SUMMARY = "AEMET OpenData Rest API library"
HOMEPAGE = "https://github.com/Noltari/AEMET-OpenData"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=60d644347832d2dd9534761f6919e2a6"

SRC_URI[sha256sum] = "26c9cd0a908ae9b0b029bdaefdf05a0d01c90108294a932f049fef479b693a4f"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "aemet_opendata"

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-geopy\
"
