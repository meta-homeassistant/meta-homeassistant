SUMMARY = "Python library to control Shelly"
HOMEPAGE = "https://github.com/home-assistant-libs/aioshelly"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"

SRC_URI[sha256sum] = "d2bfab36e620571e8b3141adb2742a3361c8e2983fbe0b987b76c4bdbc3ef056"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-bluetooth-data-tools (>=1.19.0) \
    python3-core (>=3.10) \
    python3-habluetooth (>=2.1.0) \
    python3-orjson (>=3.8.1) \
    python3-yarl \
"
