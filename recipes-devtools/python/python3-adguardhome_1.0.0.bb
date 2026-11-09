# FIXME: the LIC_FILES_CHKSUM values have been updated by 'devtool upgrade'.
# The following is the difference between the old and the new license text.
# Please update the LICENSE value if needed, and summarize the changes in
# the commit message via 'License-Update:' tag.
# (example: 'License-Update: copyright years updated.')
#
# The changes:
#
# --- LICENSE.md
# +++ LICENSE.md
# @@ -1,6 +1,6 @@
#  # MIT License
#
# -Copyright (c) 2019-2025 Franck Nijhof
# +Copyright (c) 2019-2026 Franck Nijhof
#
#  Permission is hereby granted, free of charge, to any person obtaining a copy
#  of this software and associated documentation files (the "Software"), to deal
#
#

SUMMARY = "Asynchronous Python client for the AdGuard Home API."
HOMEPAGE = "https://github.com/frenck/python-adguardhome"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=0b474a0b41cef2f146baaa56d3c4f8ee"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7f11121d5c1685d95d29eb2c7877fabc32a49fe9d229e7ce395a0dc3e31986fe"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-awesomeversion \
    python3-core (>=3.11) \
    python3-mashumaro \
    python3-orjson \
    python3-yarl (>=1.6.0) \
"
