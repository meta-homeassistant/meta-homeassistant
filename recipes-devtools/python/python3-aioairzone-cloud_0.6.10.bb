SUMMARY = "Library to control Airzone Cloud devices"
HOMEPAGE = "https://github.com/Noltari/aioairzone-cloud"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI[sha256sum] = "1879047fb57e8c914763dbdc437bbe266d777b510c29d13ba3099ff8f5963b58"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "aioairzone_cloud"
RDEPENDS:${PN} = "python3-aiohttp"
