SUMMARY = "Library to emulate a roku server to serve as a proxyfor remotes such as Harmony"
HOMEPAGE = "https://gitlab.com/mindig.marton/emulated_roku"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=85d885f0b72ad13391011925c3f9ad98"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "9dcf0a0d277ba591c7e6e1e2ab202c9cd02b6d7e80fd87c8016cf8e4c8b18a64"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp (>=3)"

PYPI_PACKAGE = "emulated_roku"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
