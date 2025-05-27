# FIXME: the LIC_FILES_CHKSUM values have been updated by 'devtool upgrade'.
# The following is the difference between the old and the new license text.
# Please update the LICENSE value if needed, and summarize the changes in
# the commit message via 'License-Update:' tag.
# (example: 'License-Update: copyright years updated.')
#
# The changes:
#
# --- README.rst
# +++ README.rst
# @@ -1 +1 @@
# -The software is subject to the MIT license.
# +
# 
#

SUMMARY = "Pure Python FNV hash implementation"
HOMEPAGE = "https://github.com/znerol/py-fnvhash"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README.rst;beginline=29;endline=29;md5=68b329da9893e34099c7d8ad5cb9c940"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi setuptools3

SRC_URI[sha256sum] = "0c7e885f44c8f06de07f442befebc590ee9ca0cc88846681f608496284ce9cd5"

