SUMMARY = "A python wrapper for telegram bots"
HOMEPAGE = " https://github.com/python-telegram-bot/python-telegram-bot"
LICENSE = "LGPL-3.0 & GPL-3.0"

LIC_FILES_CHKSUM = "\
    file://LICENSE.lesser;md5=18573f58d9b7be1ba4be5a5e1c6f2e3b \
    file://LICENSE;md5=63f576b3c3e14b4ffb122c8f9014e151 \
    "

inherit pypi

SRC_URI[md5sum] = "6afd6847463f2b31ff71d5a846615141"
SRC_URI[sha256sum] = "f5c3233bea7c7adf165e31225bbe9f28717e9f1f5070ebe99a4757c31c27ab28"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-future \
    ${PYTHON_PN}-certifi \
    ${PYTHON_PN}-ujson \
    ${PYTHON_PN}-pysocks \
    "
