SUMMARY = "Provide HDMI CEC devices as objects, especially for use with Home Assistant"
HOMEPAGE = "https://github.com/konikvranik/pycec/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e62476f516ba645845916e686710652f"

PYPI_PACKAGE = "pyCEC"
PYPI_PACKAGE_EXT = "zip"
inherit pypi setuptools3

SRC_URI[md5sum] = "a107e9bb0cdb3be203c979c54fe9483e"
SRC_URI[sha256sum] = "aae1d7e32bb875b402ab24e7a7eaa1a98b1e82a9093432c14e6a8d4e2e0db3e1"

RDEPENDS_${PN} = "python3-libcec"
