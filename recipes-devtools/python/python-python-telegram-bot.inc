SUMMARY = "A python wrapper for telegram bots"
HOMEPAGE = " https://github.com/python-telegram-bot/python-telegram-bot"
LICENSE = "LGPL-3.0 & GPL-3.0"

LIC_FILES_CHKSUM = "\
    file://LICENSE.lesser;md5=18573f58d9b7be1ba4be5a5e1c6f2e3b \
    file://LICENSE;md5=63f576b3c3e14b4ffb122c8f9014e151 \
    "

inherit pypi

SRC_URI[md5sum] = "2cfc4dfd6f6796a7bf27835a441208ab"
SRC_URI[sha256sum] = "580390d75a63706647962556bab69c7313bee1438411288c37f545e421498e6c"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-future \
    ${PYTHON_PN}-certifi \
    ${PYTHON_PN}-ujson \
    ${PYTHON_PN}-pysocks \
    "
