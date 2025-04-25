SUMMARY = "Async Python wrapper for the AfterShip API."
HOMEPAGE = "https://github.com/ludeeus/pyaftership"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENCE.md;md5=e22338b7b26962d453723c27a8cab79c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "0c3c368499388936c291801a551b82300fef77cf3fb0a04b50deb8958dc28543"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.6.1) \
"
