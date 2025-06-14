SUMMARY = "Async Python wrapper for the AfterShip API."
HOMEPAGE = "https://github.com/ludeeus/pyaftership"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENCE.md;md5=e22338b7b26962d453723c27a8cab79c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "b1438bb40590c6528ef2dfaacf92e491f23efaecf119e3ecae5b0f9b4d863956"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.6.1) \
"
