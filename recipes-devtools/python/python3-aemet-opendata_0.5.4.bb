SUMMARY = "AEMET OpenData Rest API library"
HOMEPAGE = "https://github.com/Noltari/AEMET-OpenData"
LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=60d644347832d2dd9534761f6919e2a6"

SRC_URI[sha256sum] = "a5cf5a7201f6091566013e2711e8405b1d41c2f8827337f92eadd4d2c35dcf24"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "aemet_opendata"

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-geopy\
"
