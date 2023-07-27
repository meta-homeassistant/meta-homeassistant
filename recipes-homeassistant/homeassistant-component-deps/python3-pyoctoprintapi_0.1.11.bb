SUMMARY = "Octoprint API wrapper"
HOMEPAGE = "https://github.com/rfleming71/pyoctoprintapi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=62642aee8c8da4a6a3dcbdafbb9c5b79"

SRC_URI[md5sum] = "15d7c90835d2932c208436bf45e19cd6"
SRC_URI[sha256sum] = "d321822bee6ac6af18dc5afb21121dcfce0db29845986d1b311afca472424eb9"

inherit pypi setuptools3

RDEPENDS:${PN} = "\
    ${PYTHON_PN}-aiohttp \
"
