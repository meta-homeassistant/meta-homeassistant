# FIXME: the LIC_FILES_CHKSUM values have been updated by 'devtool upgrade'.
# The following is the difference between the old and the new license text.
# Please update the LICENSE value if needed, and summarize the changes in
# the commit message via 'License-Update:' tag.
# (example: 'License-Update: copyright years updated.')
#
# The changes:
#
# --- PKG-INFO
# +++ PKG-INFO
# @@ -1 +1 @@
# -Author-email: brandonrothweiler@gmail.com
# +Requires-Python: >=3.10,<4.0
# 
#

SUMMARY = "A Python client library for A. O. Smith water heaters"
HOMEPAGE = "https://github.com/bdr99/py-aosmith"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=8;endline=8;md5=8afcf31bd10bbe304f13798fbb1feb3b"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "2fc20c40eeee267148b072dc4fbea18e43024103686399fc3ec61917803ea1a7"

inherit pypi python_poetry_core

PYPI_PACKAGE = "py_aosmith"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-aiohttp (>= 3.8.6) \
    python3-tenacity (>=8.2.3) \
"
