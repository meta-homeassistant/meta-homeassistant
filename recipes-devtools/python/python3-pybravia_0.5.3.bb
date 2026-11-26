SUMMARY = "Python async library for remote control of Sony Bravia TVs 2013 and newer."
HOMEPAGE = "https://github.com/Drafteed/pybravia"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=75c276b219eb963094e3605b275e3116"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "54e80b08c2809dd05562a7c4f5bfb995b902c0b4d7f6505e7ea3f77d85e1bdbf"

inherit pypi python_hatchling

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.14.0) \
    python3-yarl \
"
