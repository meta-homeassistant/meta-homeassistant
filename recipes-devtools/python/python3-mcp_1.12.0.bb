SUMMARY = "Model Context Protocol SDK"
HOMEPAGE = "https://modelcontextprotocol.io"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7ae711d8a91d3871696f50e34ad3c2d7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "\
    python3-hatchling-native \
    python3-uv-dynamic-versioning-native \
"
SRC_URI[sha256sum] = "853f6b17a3f31ea6e2f278c2ec7d3b38457bc80c7c2c675260dd7f04a6fd0e70"

inherit pypi python_hatchling ptest-python-pytest

PYPI_PACKAGE = "mcp"
RDEPENDS:${PN} = "\
    python3-anyio (>=4.5) \
    python3-httpx (>=0.27) \
    python3-httpx-sse (>=0.4) \
    python3-pydantic (>=2.8.0) \
    python3-pydantic-settings (>=2.10.1) \
    python3-starlette (>=0.27) \
    python3-multipart (>=0.0.9) \
    python3-sse-starlette (>=1.6.1) \
    python3-uvicorn (>=0.23.1) \
    python3-jsonschema (>=4.20.0) \
"
