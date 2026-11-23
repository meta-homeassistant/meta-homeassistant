SUMMARY = "Bluetooth control of Yale and August locks"
HOMEPAGE = "https://github.com/bdraco/yalexs-ble"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7d5c6f76fbe3879a8ed869874ff2b93f1181fccb5a2701edfbf91686929847c6"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-async-interrupt (>=1.1.1) \
    python3-bleak (>=3.0.2) \
    python3-bleak-retry-connector (>=4.7.1) \
    python3-cryptography (>=48.0.1) \
    python3-lru-dict (>=1.1.4) \
"
