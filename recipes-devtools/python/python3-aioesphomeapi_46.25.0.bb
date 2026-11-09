SUMMARY = "Python API for interacting with ESPHome devices."
HOMEPAGE = "https://github.com/esphome/aioesphomeapi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=12c1e6e336a5212a73dec68fd52e971e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "git://github.com/esphome/aioesphomeapi;protocol=https;tag=v${PV};branch=main \
           file://0001-pyproject.toml-accept-setuptools-84.0.patch \
           "
SRCREV = "696f12f277651e43b60874e8745dd8945850d92d"

inherit python_setuptools_build_meta ptest-python-pytest cython

RDEPENDS:${PN} += "\
    python3-aiohappyeyeballs (>=2.7.1) \
    python3-async-interrupt (>=1.2.2) \
    python3-chacha20poly1305-reuseable (>=0.13.2) \
    python3-cryptography (>=48.0.0) \
    python3-noiseprotocol (>=0.3.1) \
    python3-protobuf (>=6) \
    python3-tzdata (>=2026.3) \
    python3-tzlocal (>=5.3.1) \
    python3-zeroconf (>=0.150.0) \
"

RDEPENDS:${PN}-ptest:append = "\
    python3-image \
	python3-pytest-asyncio \
    python3-pytest-codspeed \
    python3-pytest-cov \
    python3-pytest-timeout \
"

do_install_ptest:append() {
	install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}

DEPENDS += "python3-wheel-native"
