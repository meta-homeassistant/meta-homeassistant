SUMMARY = "Python CFFI bindings to the Brotli library"
HOMEPAGE = "https://github.com/python-hyper/brotlicffi"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ae57d8a09fc8b6b164d7357339619045 \
                    file://libbrotli/LICENSE;md5=941ee9cd1609382f946352712a319b4b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "34345d8d1f9d534fcac2249e57a4c3c8801a33c9942ff9f8574f67a175e17adb"

DEPENDS = "python3-cffi-native"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-cffi"

PYPI_PACKAGE = "brotlicffi"
