SUMMARY = "The idiomatic asyncio MQTT client"
HOMEPAGE = "https://github.com/empicano/aiomqtt"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a462083fa4d830bdcf8c22a8ddf453cf"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "25a0a47d157e8f158d2da1110ea4786c0615518751e94f7b04976c977a8ff20d"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-paho-mqtt (>=2.1.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-anyio \
"
