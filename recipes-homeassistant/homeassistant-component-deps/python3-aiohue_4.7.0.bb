DESCRIPTION = "Python3 asyncio package to talk to Philips Hue"
HOMEPAGE = "https://github.com/home-assistant-libs/aiohue"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b707d50badb798e1d897f2c8f649382d"

SRC_URI[sha256sum] = "05b971ab1ac2994a14c56b35eaaa91f86ba080e9ad481b20d99d77f381bb6258"

inherit pypi setuptools3

RDEPENDS:${PN} += " \
    ${PYTHON_PN}-core (>=3.10) \
    ${PYTHON_PN}-aiohttp \
    ${PYTHON_PN}-asyncio-throttle \
    ${PYTHON_PN}-awesomeversion \
"