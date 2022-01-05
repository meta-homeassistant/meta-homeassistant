SUMMARY = "A python wrapper for telegram bots"
HOMEPAGE = " https://github.com/python-telegram-bot/python-telegram-bot"
LICENSE = "LGPL-3.0 & GPL-3.0"

LIC_FILES_CHKSUM = "\
    file://LICENSE.lesser;md5=18573f58d9b7be1ba4be5a5e1c6f2e3b \
    file://LICENSE;md5=63f576b3c3e14b4ffb122c8f9014e151 \
    "

inherit pypi

SRC_URI[md5sum] = "a1c6470f913dc18b5b4ba38531c09c8d"
SRC_URI[sha256sum] = "cca4e32ebb8da7fdf35ab2fa2b3edd441211364819c5592fc253acdb7561ea5b"

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-future \
    ${PYTHON_PN}-certifi \
    ${PYTHON_PN}-ujson \
    ${PYTHON_PN}-pysocks \
    ${PYTHON_PN}-tornado \
    ${PYTHON_PN}-cryptography \
"
