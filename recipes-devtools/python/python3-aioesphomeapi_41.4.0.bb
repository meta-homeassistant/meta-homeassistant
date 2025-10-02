SUMMARY = "Python API for interacting with ESPHome devices."
HOMEPAGE = "https://github.com/esphome/aioesphomeapi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=12c1e6e336a5212a73dec68fd52e971e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "346f79a86d1eabc9b5be575d2fc51ef64a2c67fb55530d6f02fb9a9167ba255d"

inherit pypi setuptools3 ptest-python-pytest cython

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

PYPI_PACKAGE = "aioesphomeapi"
