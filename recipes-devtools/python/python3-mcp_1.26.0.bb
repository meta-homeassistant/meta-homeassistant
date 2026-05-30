SUMMARY = "Model Context Protocol SDK"
HOMEPAGE = "https://github.com/modelcontextprotocol/python-sdk"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7ae711d8a91d3871696f50e34ad3c2d7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "\
    python3-hatchling-native \
    python3-uv-dynamic-versioning-native \
"
SRC_URI[sha256sum] = "db6e2ef491eecc1a0d93711a76f28dec2e05999f93afd48795da1c1137142c66"
SRC_URI += " file://run-ptest"

inherit pypi python_hatchling ptest-python-pytest

PYPI_PACKAGE = "mcp"
RDEPENDS:${PN} = "\
    python3-anyio (>=4.5) \
    python3-httpx (>=0.27.1) \
    python3-httpx-sse (>=0.4) \
    python3-pydantic (>=2.11.0) \
    python3-starlette (>=0.27) \
    python3-python-multipart (>=0.0.9) \
    python3-sse-starlette (>=1.6.1) \
    python3-pydantic-settings (>=2.5.2) \
    python3-uvicorn (>=0.31.1) \
    python3-jsonschema (>=4.20.0) \
    python3-pyjwt (>=2.10.1) \
    python3-typing-extensions (>=4.9.0) \
    python3-typing-inspection (>=0.4.1) \
"

RDEPENDS:${PN}-ptest:append = "\
    python3-annotated-doc \
    python3-dirty-equals \
    python3-inline-snapshot \
    python3-pytest-xdist \
    python3-pytest-examples \
    python3-requests \
    python3-shellingham \
    python3-typer \
    python3-uv \
"

do_install_ptest:append() {
    install -d ${D}${PTEST_PATH}/examples
    cp -rf ${S}/examples/* ${D}${PTEST_PATH}/examples/
    # Ensure local examples are imported instead of the unrelated python3-examples package.
    install -d ${D}${PTEST_PATH}/examples/snippets
    touch ${D}${PTEST_PATH}/examples/__init__.py
    touch ${D}${PTEST_PATH}/examples/snippets/__init__.py
    # The following items are added as tests need these files.
    install ${S}/README.md ${D}${PTEST_PATH}/
}
