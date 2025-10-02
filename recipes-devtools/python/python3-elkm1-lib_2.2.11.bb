SUMMARY = "Library for interacting with ElkM1 alarm/automation panel."
HOMEPAGE = "https://github.com/gwww/elkm1"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENCE;md5=34a0716df7fee7be0603abfdd3bf023c"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "79aa1f71b9a7fe08c1dd012df3c8c52de0ad529b2dc62ceea0a28fd21973bae7"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} += "python3-pyserial-asyncio-fast (>=0.11)"

RDEPENDS:${PN}-ptest += "\
    python3-asyncio \
    python3-attrs \
"

PYPI_PACKAGE = "elkm1_lib"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
