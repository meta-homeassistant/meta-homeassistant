# FIXME: the LIC_FILES_CHKSUM values have been updated by 'devtool upgrade'.
# The following is the difference between the old and the new license text.
# Please update the LICENSE value if needed, and summarize the changes in
# the commit message via 'License-Update:' tag.
# (example: 'License-Update: copyright years updated.')
#
# The changes:
#
# --- LICENSE
# +++ LICENSE
# @@ -186,7 +186,7 @@
#        same "printed page" as the copyright notice for easier
#        identification within third-party archives.
#  
# -   Copyright 2025 Maciej Bieniek
# +   Copyright 2026 Maciej Bieniek
#  
#     Licensed under the Apache License, Version 2.0 (the "License");
#     you may not use this file except in compliance with the License.
# 
#

SUMMARY = "Python wrapper for getting weather data from AccuWeather API."
HOMEPAGE = "https://github.com/bieniu/accuweather"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=de96e30bd9a80dc88146dfeab9b1b0ea"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "621389ab241b8cb7f51f3d306b6de86da35104068a6720aa4ac252167ba53b26"

SRC_URI = "git://github.com/bieniu/accuweather.git;protocol=https;branch=master"
SRCREV = "d34b81ce7f7671a1434ffa7e47d8b702d5ce02e5"

inherit python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.9.4) \
    python3-orjson \
"

RDEPENDS:${PN}-ptest += "\
    python3-aioresponses \
    python3-mypy \
    python3-pytest-asyncio \
    python3-pytest-timeout \
    python3-syrupy \
"
