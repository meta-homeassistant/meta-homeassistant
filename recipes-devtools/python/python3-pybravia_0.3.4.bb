SUMMARY = "Python async library for remote control of Sony Bravia TVs 2013 and newer."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENCE;md5=75c276b219eb963094e3605b275e3116"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7bd4ede038d85c44cc0c74eb80353d18c34f29dc0bbcd1a3ea4a362996db708d"

inherit pypi python_poetry_core

PYPI_PACKAGE = "pybravia"
RDEPENDS:${PN} = "python3-aiohttp"
