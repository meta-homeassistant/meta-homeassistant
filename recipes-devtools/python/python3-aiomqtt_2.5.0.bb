SUMMARY = "The idiomatic asyncio MQTT client"
HOMEPAGE = "https://github.com/empicano/aiomqtt"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a462083fa4d830bdcf8c22a8ddf453cf"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "70e181c140a54ae736394efe2b9e865f665551a5417f6957456cc46010487b21"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-paho-mqtt (>=2.1.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-anyio \
"
