SUMMARY = "Automation Library for Denon AVR receivers"
HOMEPAGE = "https://github.com/ol-iver/denonavr"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2bbe05b8b4b82a54f4a620c192e6a47d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "53e9a8ba4c2ed36b9c6fb258ce3c200e2d6d8940a9cd38bb93e52a065969421a"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "denonavr"
RDEPENDS:${PN} = "\
    python3-asyncstdlib (>=3.10.2) \
    python3-attrs (>=21.2.0) \
    python3-defusedxml (>=0.7.1) \
    python3-ftfy (>=6.1.1) \
    python3-httpx (>=0.23.1) \
    python3-netifaces (>=0.11.0) \
"
