SUMMARY = "A python interface to the Escea fireplace controllers"
HOMEPAGE = "https://github.com/lazdavila/pescea"
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bd1bcac9344e308fc625d1be0c81f168"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "231e36d16fb22a215cbed5fc7cac204115c2cb58b5c9a0b59e31a9e981e5469b"

inherit pypi setuptools3

RDEPENDS:${PN} += "python3-async-timeout"

PYPI_PACKAGE = "pescea"
