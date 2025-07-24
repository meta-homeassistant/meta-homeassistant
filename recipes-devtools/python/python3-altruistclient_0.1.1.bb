SUMMARY = "Async library for discovering and fetching data from Altruist sensors"
HOMEPAGE = "https://github.com/LoSk-p/altruistclient"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8506083edc8b6070835800630c3f5cd0"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d4f786bcebaf42c411ef1ddb1a226f935b38147c4ff9275ed3622e37ca2a49a1"

inherit pypi python_poetry_core

PYPI_PACKAGE = "altruistclient"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.11.0) \
    python3-zeroconf (>=0.143.0) \
"
