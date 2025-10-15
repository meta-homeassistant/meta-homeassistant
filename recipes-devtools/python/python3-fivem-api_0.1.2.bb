SUMMARY = "A library to query info, players and resources from FiveM server"
HOMEPAGE = "https://github.com/Sander0542/fivem-api"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0a228e1a03844fba088d26eba18a764e"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "ea596b30659b0d19b2b04c3e07a075d7984b4b9c6592d4045e2487ccf2db579b"

DEPENDS = "python3-setuptools-scm-native"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-aiohttp (>=3.8.1)"

PYPI_PACKAGE = "fivem-api"
