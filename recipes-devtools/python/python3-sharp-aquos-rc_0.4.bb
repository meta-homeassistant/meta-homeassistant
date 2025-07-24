SUMMARY = "Control Sharp Aquos SmartTVs through the IP interface."
HOMEPAGE = "https://github.com/jmoore987/sharp_aquos_rc"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "956609d9a253d4b62d2ccc0857a8ed5a53947fe0f5131d6b53aea4dbe258ee3b"

inherit pypi setuptools3

PYPI_PACKAGE = "sharp_aquos_rc"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
