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
# -License: MIT
# +Keywords: api,async,client,elgato,home-assistant,key light,key light air,key light mini,keylight,light strip
#
#

SUMMARY = "Asynchronous Python client for Elgato Lights."
HOMEPAGE = "https://github.com/frenck/python-elgato"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://PKG-INFO;beginline=6;endline=6;md5=8d24eaf4cdd167ca1480929c061ed5d2"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "21efb43fa0666d4486959ed6324b9e153fcd2777f57b865f1441c70a1e4d2135"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-cryptography \
    python3-mashumaro (>=3.10) \
    python3-orjson (>=3.9.8) \
    python3-yarl (>=1.6.0) \
"
