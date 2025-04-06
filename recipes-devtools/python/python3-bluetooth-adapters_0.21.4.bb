SUMMARY = "Tools to enumerate and find Bluetooth Adapters"
HOMEPAGE = "https://github.com/bluetooth-devices/bluetooth-adapters"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=732518afbb3ba92dbf606e49f9045cc9"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "a5a809ef7ba95ee673a78704f90ce34612deb3696269d1a6fd61f98642b99dd3"

inherit pypi python_poetry_core ptest

PYPI_PACKAGE = "bluetooth_adapters"

RDEPENDS:${PN} = "\
    python3-aiooui (>=0.1.1) \
    python3-bleak (>=0.21.1) \
    python3-core (>3.9) \
    python3-uart-devices (>=0.1.0) \
"
