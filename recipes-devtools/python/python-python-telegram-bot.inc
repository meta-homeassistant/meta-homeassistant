SUMMARY = "A python wrapper for telegram bots"
HOMEPAGE = " https://github.com/python-telegram-bot/python-telegram-bot"
LICENSE = "LGPL-3.0"

LIC_FILES_CHKSUM = "file://LICENSE.lesser;md5=b5e076db5271f01d659c57498ca50fb7"

inherit pypi

SRC_URI[md5sum] = "09ad2c160fb13ffce1ed2c67d3d3501d"
SRC_URI[sha256sum] = "238c4a88b09d93c52d413bcf7e7fe14dfeb02f5f9222ffe4cafd4bd3d55489a3"

RDEPENDS_${PN} = "${PYTHON_PN}-future ${PYTHON_PN}-certifi ${PYTHON_PN}-ujson ${PYTHON_PN}-pysocks"
