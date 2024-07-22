SUMMARY = "Python library to control Shelly"
HOMEPAGE = "https://github.com/home-assistant-libs/aioshelly"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"

SRC_URI[sha256sum] = "ef3f5e0d4d789240c2fc727d61511eab2589b55220b07fa7bb552c25b701bcd3"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-bluetooth-data-tools (>=1.19.0) \
    python3-core (>=3.11) \
    python3-habluetooth (>=2.1.0) \
    python3-orjson (>=3.8.1) \
    python3-yarl \
"

RDEPENDS:${PN}-ptest = "\
    python3-python-switchbot \
"
