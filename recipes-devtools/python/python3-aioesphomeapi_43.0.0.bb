SUMMARY = "Python API for interacting with ESPHome devices."
HOMEPAGE = "https://github.com/esphome/aioesphomeapi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=12c1e6e336a5212a73dec68fd52e971e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "82fc92d3d9b71c4bbf8fe0a3d0fe8ba120b78cc9153c566ce07bf43fb69037f8"
SRC_URI = "git://github.com/esphome/aioesphomeapi;protocol=https;tag=v${PV};branch=main"

inherit setuptools3 ptest-python-pytest cython

RDEPENDS:${PN} += "\
    python3-aiohappyeyeballs (>=2.3.0) \
    python3-async-interrupt (>=1.2.0) \
    python3-protobuf (>=6) \
    python3-tzlocal (>=5.0) \
    python3-zeroconf (>=0.143.0) \
    python3-chacha20poly1305-reuseable (>=0.13.2) \
    python3-cryptography (>=43.0.0) \
    python3-noiseprotocol (>=0.3.1) \
"

RDEPENDS:${PN}-ptest:append = "\
	python3-pytest-asyncio \
    python3-pytest-codspeed \
    python3-pytest-cov \
    python3-pytest-timeout \
"

do_install_ptest:append() {
	install ${S}/pyproject.toml ${D}${PTEST_PATH}/
}