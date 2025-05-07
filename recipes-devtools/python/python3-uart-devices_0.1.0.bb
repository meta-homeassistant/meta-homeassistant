SUMMARY = "UART Devices for Linux"
HOMEPAGE = "https://github.com/bdraco/uart-devices"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c8ea148e26a1546c1b0a99524d4da3f7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI = "\
    git://github.com/bdraco/uart-devices.git;protocol=https;branch=main \
"
SRCREV = "154f4b3efb7763097a050107e9585126594ebac2"

S = "${WORKDIR}/git"

inherit python_poetry_core ptest-python-pytest

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
"
