SUMMARY = "API Client for Foobot Air Quality Monitoring devices."
HOMEPAGE = "https://github.com/reefab/foobot_async"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=7;endline=7;md5=8227180126797a0148f94f483f3e1489"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "4108f2b24da6f1090ea4b05d0bc91fba803d3dc963804c332b2ac8021c470787"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.10.0) \
    python3-async-timeout \
"

PYPI_PACKAGE = "foobot_async"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
