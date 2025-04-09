SUMMARY = "Python wrapper for getting weather data from AccuWeather API."
HOMEPAGE = "https://github.com/bieniu/accuweather"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=5ff265943ef567b5278a97f2ffaac1a3"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "621389ab241b8cb7f51f3d306b6de86da35104068a6720aa4ac252167ba53b26"

SRC_URI = "git://github.com/bieniu/accuweather.git;protocol=https;branch=master"
SRCREV = "0363bdb54ff96c7c26b40ca632fd956add10eed4"

inherit python_setuptools_build_meta ptest-python-pytest

S = "${WORKDIR}/git"

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
