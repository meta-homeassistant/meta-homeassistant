SUMMARY = "A package to retrieve FAA airport status"
HOMEPAGE = "https://github.com/ntilley905/faadelays"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=eea0ffe4537e94f318b859af8b91f390"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "9e030577e044de129e69e1845f8c47a730c8aed1850ec4b0c416eb73864c15ab"

inherit pypi python_setuptools_build_meta

RDEPENDS:${PN} = "python3-aiohttp"

PYPI_PACKAGE = "faadelays"
