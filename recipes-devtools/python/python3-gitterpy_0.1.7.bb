SUMMARY = "Python interface for the Gitter API"
HOMEPAGE = "https://github.com/MichaelYusko/GitterPy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=f0a3e4a2554ebb89c046c93d45d8e4bc"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "67a01cfdb91bb3ee81ec3a2eeacab42f0887b606463877bc08c636e873538940"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-requests (>=2.13.0)"

