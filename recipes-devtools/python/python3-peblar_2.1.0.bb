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
# -Copyright (c) 2023-2024 Franck Nijhof
# +Copyright (c) 2023-2026 Franck Nijhof
#
#  Permission is hereby granted, free of charge, to any person obtaining a copy
#  of this software and associated documentation files (the "Software"), to deal
#
#

SUMMARY = "Asynchronous Python client for Peblar EV chargers."
HOMEPAGE = "https://github.com/frenck/python-peblar"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=07ea1f7ab34983f046b8845cb72ee511"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "8c9c5016daea64f2e6f5435f1940323dd7ef4e9a82db0e3c2ab6005bee5619e0"

inherit pypi python_poetry_core ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.0.0) \
    python3-awesomeversion (>=22.8.0) \
    python3-mashumaro (>-3.10) \
    python3-orjson (>=3.9.8) \
    python3-tenacity \
    python3-yarl (>=1.6.0) \
"

RDEPENDS:${PN}-ptest += "\
    python3-coverage \
"

