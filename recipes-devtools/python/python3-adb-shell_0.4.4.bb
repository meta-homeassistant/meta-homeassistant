SUMMARY = "A Python implementation of ADB with shell and FileSync functionality."
HOMEPAGE = "https://github.com/JeffLIrion/adb_shell"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2ee41112a44fe7014dce33e26468ba93"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "04c305f30a2ca25d5c54b3cd6ce9bb64c36e5f07967b23b3fb6aaecc851b90b6"
SRC_URI = "git://github.com/JeffLIrion/adb_shell;protocol=https;tag=v${PV};branch=master"

inherit setuptools3 ptest-python-pytest

PACKAGECONFIG ?= "async"
PACKAGECONFIG[async] = ",,,python3-aiofiles python3-async-timeout"
PACKAGECONFIG[usb] = ",,,python3-libusb1"

RDEPENDS:${PN} += "\
    python3-cryptography \
    python3-pyasn1 \
    python3-rsa \
"

RDEPENDS:${PN}-ptest += "\
    python3-libusb1 \
    python3-pycryptodome \
"

PYPI_PACKAGE = "adb_shell"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
