SUMMARY = "A loose python wrapper around the ZoneMinder REST API."
HOMEPAGE = "https://github.com/rohankapoorcom/zm-py"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=2b42edef8fa55315f34f2370b4715ca9"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d46adb019b8fd01f60b8138126e6b22fce687bca4e85ab1a2695d9e9136cac8f"

inherit pypi python_poetry_core ptest-python-pytest


RDEPENDS:${PN} = "python3-requests"
