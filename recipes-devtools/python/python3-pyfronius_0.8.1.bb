SUMMARY = "Client for Fronius SolarAPI JSON interface"
HOMEPAGE = "https://github.com/nielstron/pyfronius/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=90d9cd3b10a2c3b9b17973b0b96f80d4"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "428dda66c47611ff72bedf991dd4dd9df2bbddb54ee5414e40e4c2b28aa8a764"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "python3-aiohttp"
