SUMMARY = "The official Python SDK for ElevenLabs."
HOMEPAGE = "https://elevenlabs.io/"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7f38b85ad508cdbe608b4d36f598839f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "3a26ea20a3ce4a30ffada125f77b102bd88dc2d3230a912bd144017087d36795"

inherit pypi python_poetry_core

RDEPENDS:${PN} += " \
    python3-httpx (>=0.21.2) \
    python3-pydantic (>=1.9.2) \
    python3-pydantic-core (>=2.18.2) \
    python3-requests (>=2.20) \
    python3-typing-extensions (>=4.0.0) \
    python3-websockets (>=11.0) \
"
