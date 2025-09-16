SUMMARY = "Python API to interact with Dexcom Share API"
HOMEPAGE = "https://gagebenne.github.io/pydexcom"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3b42663d7239918488929ae217aaa784"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "025014134f229b385b296db10788d73c8322c398d3aa85b01be6db8b67d101b3"

inherit pypi setuptools3 ptest-python-pytest

PYPI_PACKAGE = "pydexcom"
RDEPENDS:${PN} = "python3-requests (>=2.0)"
