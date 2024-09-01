SUMMARY = "Mock out requests made by ClientSession from aiohttp package"
HOMEPAGE = "https://github.com/pnuckowski/aioresponses"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b22b40d5974300051216633098387c57"

SRC_URI += "file://0001-Make-project-PEP-517-compliant.patch"
SRC_URI[sha256sum] = "f795d9dbda2d61774840e7e32f5366f45752d1adc1b74c9362afd017296c7ee1"

DEPENDS += "\
    python3-pbr-native \
"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} += "python3-aiohttp"

PYPI_PACKAGE = "aioresponses"
