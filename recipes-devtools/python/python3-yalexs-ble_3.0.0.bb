SUMMARY = "Bluetooth control of Yale and August locks"
HOMEPAGE = "https://github.com/bdraco/yalexs-ble"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e62637ea8a114355b985fd86c9ffbd6e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "609ab711e9625a69e3632717c600f8ee3fef37d58945d998f0c9823307603b56"

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
