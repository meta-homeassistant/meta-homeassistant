
SUMMARY = "A python wrapper for telegram bots"
HOMEPAGE = " https://github.com/python-telegram-bot/python-telegram-bot"
LICENSE = "LGPLv3"
SRCNAME = "python-python-telegram-bot"

LIC_FILES_CHKSUM = "file://LICENSE;md5=63f576b3c3e14b4ffb122c8f9014e151"

inherit pypi

SRC_URI[md5sum] = "b6bd4ed1df38ee6b35fe591b05b4dbcd"
SRC_URI[sha256sum] = "494ffdd76ffcca62ce6276906b0afe6e8e8c4245b78501404f723aec79949bff"

RDEPENDS_${PN} = "\
	${PYTHON_PN}-future \
"
