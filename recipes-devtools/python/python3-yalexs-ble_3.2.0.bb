SUMMARY = "Bluetooth control of Yale and August locks"
HOMEPAGE = "https://github.com/bdraco/yalexs-ble"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e62637ea8a114355b985fd86c9ffbd6e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "10e24e4b49a689f51ddb510a34e56e65a5269f6b7dc4f17efbf27104cf480673"

inherit pypi python_poetry_core

PYPI_PACKAGE = "yalexs_ble"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-bleak (>=0.19.0) \
    python3-bleak-retry-connector (>=3.4.0) \
    python3-cryptography (>=38.0.0) \
    python3-lru-dict (>=1.1.4) \
    python3-async-interrupt (>=1.1.1) \
"
