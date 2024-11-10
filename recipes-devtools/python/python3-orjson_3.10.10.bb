SUMMARY = "Fast, correct Python JSON library supporting dataclasses, datetimes, and numpy"
HOMEPAGE = "https://pypi.org/project/orjson/"
LICENSE = "Apache-2.0 | MIT"
LIC_FILES_CHKSUM = "file://LICENSE-APACHE;md5=1836efb2eb779966696f473ee8540542"

PYPI_PACKAGE = "orjson"

SRC_URI[sha256sum] = "37949383c4df7b4337ce82ee35b6d7471e55195efa7dcb45ab8226ceadb0fe3b"
SRC_URI:append = " \
    file://0001-Fix-compilation-error-for-orjson.patch \
"

inherit pypi python_maturin
