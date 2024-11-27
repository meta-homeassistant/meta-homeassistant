SUMMARY = "A simple API for AirVisual air quality data"
HOMEPAGE = "https://github.com/bachya/pyairvisual"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=51d385c25872662fea76588b089e43f5"

SRC_URI += "file://0001-Remove-poetryversion-req.patch"
SRC_URI[sha256sum] = "5898835815160101710769072083850f7e4d638236aa7f5240316e594d6a38ad"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.8.0) \
    python3-certifi (>=2023.07.22) \
    python3-numpy (>=1.22.0) \
    python3-pygments (>=2.15.0) \
    python3-pysmb (>=1.2.6) \
"

PYPI_PACKAGE = "pyairvisual"
