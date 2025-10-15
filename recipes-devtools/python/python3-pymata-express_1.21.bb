SUMMARY = "A Python Protocol Abstraction Library For Arduino Firmata using Python asyncio"
HOMEPAGE = "https://mryslab.github.io/pymata-express/"
LICENSE = "AGPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=6474dfa1f39105bd169d564e5263e262"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "1417197ef601c3515829801c2afac158b1c24a78d7590adfdd38231d21c394d1"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-pyserial"

PYPI_PACKAGE = "pymata-express"
