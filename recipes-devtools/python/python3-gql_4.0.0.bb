SUMMARY = "GraphQL client for Python"
HOMEPAGE = "https://github.com/graphql-python/gql"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f38bd223275f617b47d97eacc029647f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f22980844eb6a7c0266ffc70f111b9c7e7c7c13da38c3b439afc7eab3d7c9c8e"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} += "\
    python3-aiohttp (>=3.11.2) \
    python3-anyio (>=3.0) \
    python3-backoff (>=1.11.1) \
    python3-botocore (>=1.21.0) \
    python3-graphql-core (>=3.2) \
    python3-httpx (>=0.23.1) \
    python3-requests (>=2.26) \
    python3-requests-toolbelt (>=1.0.0) \
    python3-websockets (>=14.2) \
    python3-yarl (>=1.6) \
"

RDEPENDS:${PN}-ptest += "\
    python3-aiofiles \
    python3-mock \
    python3-parse \
    python3-pytest-asyncio \
    python3-pytest-console-scripts \
    python3-pytest-cov \
    python3-vcrpy \
    python3-aiofiles \
"

PYPI_PACKAGE = "gql"
