SUMMARY = "A Python library to communicate with the flux_led smart bulbs"
HOMEPAGE = "https://github.com/Danielhiversen/flux_led"
LICENSE = "LGPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=e6a600fd5e1d9cbde2d983680233ad02"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3cfb68df243bdc9bdde6a91e9d05960949de70b8a76fdb799b70021c54380c3d"

inherit pypi setuptools3 ptest-python-pytest

SRC_URI += "file://0001-Remove-setup-requires-unneeded-for-OE-build.patch"

RDEPENDS:${PN} += "\
    python3-async-timeout (>=3.0.0) \
    python3-webcolors \
"

RDEPENDS:${PN}-ptest += "\
    python3-pytest-asyncio \
"

PYPI_PACKAGE = "flux_led"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
