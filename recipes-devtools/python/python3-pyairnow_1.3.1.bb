SUMMARY = "A lightweight Python wrapper for EPA AirNow Air Quality API"
HOMEPAGE = "https://github.com/asymworks/pyairnow"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d867984564a4e043b6c395e4826752f2"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "55bec36a1460e8823a7e10a30c9459affa52dd6e4068232a67932727a36aef5f"

inherit pypi python_poetry_core

PYPI_PACKAGE = "pyairnow"
RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.8.3) \
"
