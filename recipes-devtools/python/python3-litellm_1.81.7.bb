SUMMARY = "Library to easily interface with LLM API providers"
HOMEPAGE = "https://litellm.ai"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7dfeaff60248d9823ed8ab2264885da2 \
                    file://enterprise/LICENSE.md;md5=46a5145af77e8681c83e9dfcb8a84eb6 \
                    file://litellm/proxy/auth/litellm_license.py;md5=886b1626ffa9e9bb0bca4cb506113d35"
SRC_URI[sha256sum] = "442ff38708383ebee21357b3d936e58938172bae892f03bc5be4019ed4ff4a17"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

inherit pypi python_poetry_core

RDEPENDS:${PN} += " \
    python3-fastuuid \
    python3-httpx \
    python3-openai \
    python3-python-dotenv \
    python3-tiktoken \
    python3-importlib-metadata \
    python3-tokenizers \
    python3-click \
    python3-jinja2 \
    python3-aiohttp \
    python3-pydantic \
    python3-jsonschema \
    bash \
"
