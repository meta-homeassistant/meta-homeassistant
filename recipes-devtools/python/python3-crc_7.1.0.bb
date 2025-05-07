SUMMARY = "Pure Python CRC library"
HOMEPAGE = "https://nicoretti.github.io/crc/"
LICENSE = "BSD-2-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=f94c07350a9f2e0ce3a246fed3b32353"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "99dd540909a37ae4f62c65441df8ecb4e7f9af014fecaf4f331052a41d66c07d"

inherit pypi python_poetry_core

PYPI_PACKAGE = "crc"
