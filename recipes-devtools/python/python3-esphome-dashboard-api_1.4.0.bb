SUMMARY = "API to interact with ESPHome Dashboard"
HOMEPAGE = "https://github.com/esphome/dashboard-api"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5a588bcbe30e4d6b149fa57244eede5e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7b9736c77998033cc97ef4dfc15a89a4552114ab3596fd277141d8eedb127a7e"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "python3-aiohttp python3-orjson"
