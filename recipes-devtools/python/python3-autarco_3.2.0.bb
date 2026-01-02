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
# @@ -1,6 +1,6 @@
#  # MIT License
#  
# -Copyright (c) 2022-2024 Klaas Schoute
# +Copyright (c) 2022-2025 Klaas Schoute
#  
#  Permission is hereby granted, free of charge, to any person obtaining a copy
#  of this software and associated documentation files (the "Software"), to deal
# 
#

SUMMARY = "Asynchronous Python client for the Autarco Inverters"
HOMEPAGE = "https://github.com/klaasnicolaas/python-autarco"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b248c7449204ac62e20885f38e385888"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "94d7dc1e4ddbad24167638fe012f5e8b0dacb688c297f75a2d3ca29ab6768271"

inherit pypi python_poetry_core

PYPI_PACKAGE = "autarco"

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-mashumaro (>=3.12) \
    python3-orjson (>=3.9.14) \
    python3-yarl (>=1.6.0) \
"
