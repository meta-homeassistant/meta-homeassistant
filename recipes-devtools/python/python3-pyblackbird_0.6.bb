SUMMARY = "Python API for talking to Monoprice Blackbird 4k 8x8 HDBaseT Matrix"
HOMEPAGE = "https://github.com/koolsb/pyblackbird"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b987cde240fbe5031bde4e50f2e15390"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "\
    git://github.com/koolsb/pyblackbird.git;protocol=https;branch=master;tag=${PV} \
    file://0001-Fix-asyncio-compatibility.patch \
"
SRC_URI[sha256sum] = "22aefafec2cba93bbe43d60c2b8c065dc6876638eb38723dd4c6439a4d57da86"

inherit setuptools3 ptest-python-pytest

RDEPENDS:${PN} = "\
    python3-pyserial (>=3.4) \
    python3-pyserial-asyncio (>=0.4) \
"

RDEPENDS:${PN}-ptest += "\
    python3-terminal \
"
