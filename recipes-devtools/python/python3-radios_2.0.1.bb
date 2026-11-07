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
# -Copyright (c) 2022-2024 Franck Nijhof
# +Copyright (c) 2022-2026 Franck Nijhof
#
#  Permission is hereby granted, free of charge, to any person obtaining a copy
#  of this software and associated documentation files (the "Software"), to deal
#
#

SUMMARY = "Asynchronous Python client for the Radio Browser APIt"
HOMEPAGE = "https://github.com/frenck/python-radios"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=b4ba024c7d738e1998f700f44772b3f6"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "78a2ce349787e47d203fbd429f4f089e2db77314a7872eb6cb8e91c69ebd53ac"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiodns (>=3.0) \
    python3-aiohttp (>=3.0.0) \
    python3-awesomeversion (>=21.10.1) \
    python3-core (>=3.11) \
    python3-mashumaro (>= 3.10) \
    python3-orjson (>=3.9.8) \
    python3-probatio \
    python3-pycares \
    python3-yarl (>=1.6.0) \
"
