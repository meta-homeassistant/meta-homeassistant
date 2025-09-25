SUMMARY = "ahocorapy - Pure python ahocorasick implementation"
HOMEPAGE = "https://github.com/abusix/ahocorapy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=47a7aa93b058fbe3dd95a66eb11886e0"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "67a01cfdb91bb3ee81ec3a2eeacab42f0887b606463877bc08c636e873538940"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-future"

PYPI_PACKAGE = "ahocorapy"
