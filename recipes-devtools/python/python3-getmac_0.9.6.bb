SUMMARY = "Platform-independent pure-Python module to get a MAC address"
HOMEPAGE = "https://github.com/GhostofGoes/getmac"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=31a1bcc022ed7c0b08b8f4894f708147"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "1539673e819e5856ea9707434f939355c9a9a043d3566224addf52976d804103"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN}-ptest += "\
    python3-pytest-mock \
    python3-pytest-benchmark \
"
