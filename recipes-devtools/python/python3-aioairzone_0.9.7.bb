SUMMARY = "Library to control Airzone devices"
HOMEPAGE = "https://github.com/Noltari/aioairzone"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"

SRC_URI[sha256sum] = "8712b32e127d855e216e6b60fbe8465dba6210a5ca78e61817460cc99777935e"

inherit pypi python_setuptools_build_meta

PYPI_PACKAGE = "aioairzone"
RDEPENDS:${PN} = "python3-aiohttp"
