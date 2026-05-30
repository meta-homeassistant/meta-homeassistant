SUMMARY = "A python3 library to communicate with Adax"
HOMEPAGE = "https://github.com/Danielhiversen/pyAdaxLocal"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2736a6a8b58491968000c6e0130f0471"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-remove-broken-nonfunctional-requirement.patch"
SRC_URI[sha256sum] = "ad3325eb7c04c03516ad85d867e362ffdaf7f2b3dee3f94f6ab55ec123a2e32c"

inherit pypi setuptools3

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.0.6) \
    python3-async-timeout (>=1.4.0) \
    python3-bleak \
"

PYPI_PACKAGE = "adax_local"
