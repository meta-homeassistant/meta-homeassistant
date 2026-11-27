SUMMARY = "Python module to talk to Atag One."
HOMEPAGE = "https://github.com/MatsNl/pyatag"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=ea82266a2e7ada1ce5e48ba01a85a21a"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "6c43d229783dd9f7c7ced80ba4cc71590d06e20a13188843d94e9627e2aa6b00"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp"
