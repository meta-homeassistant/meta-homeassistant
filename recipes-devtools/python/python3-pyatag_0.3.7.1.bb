SUMMARY = "Python module to talk to Atag One."
HOMEPAGE = "https://github.com/MatsNl/pyatag"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=eb298faac87d10872b1c138cd1abe9e3"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "6c43d229783dd9f7c7ced80ba4cc71590d06e20a13188843d94e9627e2aa6b00"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp"
