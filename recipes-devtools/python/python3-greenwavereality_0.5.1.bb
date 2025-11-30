SUMMARY = "Control of Greenwave Reality Lights"
HOMEPAGE = "https://github.com/dfiel/greenwavereality"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=adc1f231c76ee2f1f36025d56926ba2c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "6cd4cef6a1e839edc0ed36225302c156ae1e5b21a821f0a882e8b333584a93f6"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-requests python3-urllib3 python3-xmltodict"

PYPI_PACKAGE = "greenwavereality"
