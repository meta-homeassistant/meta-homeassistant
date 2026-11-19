SUMMARY = "Python library to control Shelly"
HOMEPAGE = "https://github.com/home-assistant-libs/aioshelly"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=dab31a1d28183826937f4b152143a33f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit python_setuptools_build_meta ptest-python-pytest

SRC_URI = "git://github.com/home-assistant-libs/aioshelly;protocol=https;tag=${PV};branch=main"
SRCREV = "27fc08fddd0092419e742ff99bd2d0e9942f5593"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.14.0) \
    python3-bleak-retry-connector (>=3.0.0) \
    python3-bluetooth-data-tools (>=1.28.0) \
    python3-habluetooth (>=6.3.0) \
    python3-orjson (>=3.11.6) \
    python3-yarl \
    python3-zeroconf (>=0.148.0) \
"

RDEPENDS:${PN}-ptest:append = " \
    python3-aioresponses \
    python3-pytest-asyncio \
    python3-pytest-cov \
    python3-requests \
"

do_install_ptest:append() {
    install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}
