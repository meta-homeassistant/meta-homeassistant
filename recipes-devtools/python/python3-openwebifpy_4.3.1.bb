SUMMARY = "Provides a python interface to interact with a device running OpenWebIf"
HOMEPAGE = "https://github.com/autinerd/openwebifpy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8b47b131eba433d1fdfaa0420b7d7177"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "15aca7253f9b47ade72302c4c178d38f03d7677439fd7fb3a71d204c0dcfaa8f"

inherit pypi python_hatchling ptest-python-pytest

PYPI_PACKAGE = "openwebifpy"
RDEPENDS:${PN} = "python3-aiohttp python3-yarl"
