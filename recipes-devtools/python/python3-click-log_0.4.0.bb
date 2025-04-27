SUMMARY = "Logging integration for Click"
HOMEPAGE = "https://github.com/click-contrib/click-log"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fee2943fdd4d8afbac9ccc1c8ac137d5"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3970f8570ac54491237bcdb3d8ab5e3eef6c057df29f8c3d1151a51a9c23b975"

inherit pypi setuptools3 ptest-python-pytest

RDEPENDS:${PN} += "python3-click"
