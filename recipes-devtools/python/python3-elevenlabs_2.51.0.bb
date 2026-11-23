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
