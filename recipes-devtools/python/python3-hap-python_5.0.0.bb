SUMMARY = "HomeKit Accessory Protocol implementation in python"
HOMEPAGE = "https://github.com/ikalchev/HAP-python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9a7f7961e2e1d54a12aca53beeb18701"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/ikalchev/HAP-python.git;protocol=https;branch=master"
SRC_URI[sha256sum] = "faca4945f2abafbd5ca4a9350969e6655826ca2c88ac3a42088cc6f700ba0bb2"
SRCREV = "5f7777631f23c05c56dd5e43718f9cd3f2167ecd"

inherit python_setuptools_build_meta ptest-python-pytest

PACKAGECONFIG ?= "qrcode"
PACKAGECONFIG[qrcode] = ",,,python3-base36 python3-pyqrcode"

RDEPENDS:${PN} += "\
    python3-async-timeout \
    python3-chacha20poly1305-reuseable \
    python3-cryptography \
    python3-h11 \
    python3-orjson (>=3.7.2) \
    python3-zeroconf (>=0.36.2) \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
    python3-pytest-timeout \
    python3-pyqrcode \
"

PYPI_PACKAGE = "hap_python"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
