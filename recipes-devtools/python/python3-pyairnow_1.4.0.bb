SUMMARY = "A lightweight Python wrapper for EPA AirNow Air Quality API"
HOMEPAGE = "https://github.com/asymworks/pyairnow"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d867984564a4e043b6c395e4826752f2"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "12c7612c705f715b6340f968cc86b05ae09c5095fde02658d355abf81f2a17a1"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.8.3) \
"
