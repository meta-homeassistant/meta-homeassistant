SUMMARY = "Python wrapper for getting weather data from AccuWeather API."
HOMEPAGE = "https://github.com/bieniu/accuweather"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=de96e30bd9a80dc88146dfeab9b1b0ea"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/bieniu/accuweather.git;protocol=https;branch=master"
SRCREV = "d34b81ce7f7671a1434ffa7e47d8b702d5ce02e5"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.9.4) \
    python3-orjson \
"

RDEPENDS:${PN}-ptest += "\
    python3-aioresponses \
    python3-mypy \
    python3-pytest-asyncio \
    python3-pytest-timeout \
    python3-syrupy \
"
