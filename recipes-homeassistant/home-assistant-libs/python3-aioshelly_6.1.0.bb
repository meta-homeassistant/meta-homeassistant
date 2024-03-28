SUMMARY = "Python library to control Shelly"
HOMEPAGE = "https://github.com/home-assistant-libs/aioshelly"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"

SRC_URI[sha256sum] = "015461f2607b17b78eefa60d4b91283b97141fa63450fdcebfa02695162e9534"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-bluetooth-data-tools (>=0.3.0) \
    python3-orjson (>=3.8.1) \
    python3-core (>=3.10) \
    python3-yarl \
"
