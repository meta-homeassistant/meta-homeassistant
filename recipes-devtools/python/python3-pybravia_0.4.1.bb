SUMMARY = "Python async library for remote control of Sony Bravia TVs 2013 and newer."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=75c276b219eb963094e3605b275e3116"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "ec01960b22df0316ca82cc6b6551435923e83af722cdca1630d303d83de2aadc"

inherit pypi python_hatchling

RDEPENDS:${PN} = "\
    python3-aiohttp \
    python3-yarl \
"
