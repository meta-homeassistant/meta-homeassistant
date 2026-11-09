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
# -Copyright (c) 2022-2025 Klaas Schoute
# +Copyright (c) 2022-2026 Klaas Schoute
#
#  Permission is hereby granted, free of charge, to any person obtaining a copy
#  of this software and associated documentation files (the "Software"), to deal
#
#

SUMMARY = "Asynchronous Python client providing energy/gas prices from easyEnergy"
HOMEPAGE = "https://github.com/klaasnicolaas/python-easyenergy"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a369d15b03074464523ec50eb0b7e190"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "54b4a32f177040df60590f48eab600adbea5ec03cdcac9fb9ac56bb3da5df272"

inherit pypi python_poetry_core

RDEPENDS:${PN} = "\
    python3-aiohttp (>=3.0.0) \
    python3-mashumaro \
    python3-yarl (>=1.6.0) \
"
