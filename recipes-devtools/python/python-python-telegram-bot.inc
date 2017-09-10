SUMMARY = "A python wrapper for telegram bots"
HOMEPAGE = " https://github.com/python-telegram-bot/python-telegram-bot"
LICENSE = "LGPLv3"

LIC_FILES_CHKSUM = "file://LICENSE.lesser;md5=b5e076db5271f01d659c57498ca50fb7"

inherit pypi

SRC_URI[md5sum] = "a65924fcdf01f688a7d1556ede1b1708"
SRC_URI[sha256sum] = "b648845f9d5c3ed569066be25e5efdfa36148a24d87e7b5219b4eb8e64853b4d"

RDEPENDS_${PN} = "${PYTHON_PN}-future ${PYTHON_PN}-certifi ${PYTHON_PN}-ujson ${PYTHON_PN}-pysocks"
