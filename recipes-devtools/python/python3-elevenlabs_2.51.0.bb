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
#  MIT License
#
# -Copyright (c) 2025 Elevenlabs.
# +Copyright (c) 2026 Elevenlabs.
#
#  Permission is hereby granted, free of charge, to any person obtaining a copy
#  of this software and associated documentation files (the "Software"), to deal
#
#

SUMMARY = "The official Python SDK for ElevenLabs."
HOMEPAGE = "https://elevenlabs.io/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bd783064786d2dcbb0b113ba0f56c729"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "8c7df290cda9e5f76efa68d6e645f68f2f997874ef228492d02c4f9afb232904"

inherit pypi python_poetry_core

RDEPENDS:${PN} += "\
    python3-httpx (>=0.21.2) \
    python3-pydantic (>=1.9.2) \
    python3-pydantic-core (>=2.18.2) \
    python3-requests (>=2.20) \
    python3-typing-extensions (>=4.0.0) \
    python3-websockets (>=11.0) \
"
