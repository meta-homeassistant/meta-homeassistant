SUMMARY = "Model Context Protocol wire types"
DESCRIPTION = "The wire types for the Model Context Protocol."
HOMEPAGE = "https://modelcontextprotocol.io"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7ae711d8a91d3871696f50e34ad3c2d7"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "d1e46549edb35ee19a94940fcee6d1addd7e589ab7ea92dda83f5d84781fc362"

# The mcp_types sdist ships no tests. Its tests live in the mcp sdist of the
# same release, so the ptest takes them from there.
SRC_URI += "https://files.pythonhosted.org/packages/source/m/mcp/mcp-${PV}.tar.gz;name=mcp;subdir=mcp-tests"
SRC_URI[mcp.sha256sum] = "8b147a50441cf059dc88c684e0aeed3687f0aa0f39c6cde7b90330effd2b34d8"

inherit pypi python_hatchling ptest-python-pytest

DEPENDS += "python3-uv-dynamic-versioning-native"

RDEPENDS:${PN} += "\
    python3-pydantic \
    python3-typing-extensions \
"

RDEPENDS:${PN}-ptest += "\
    python3-anyio \
    python3-inline-snapshot \
    python3-mcp \
"

# Only the type tests: the conftest.py of the full suite needs logfire and
# blockbuster, which are not packaged.
do_install_ptest:append() {
    t=${UNPACKDIR}/mcp-tests/mcp-${PV}/tests
    install -d ${D}${PTEST_PATH}/tests/types
    install -m 0644 $t/__init__.py $t/test_types.py ${D}${PTEST_PATH}/tests/
    install -m 0644 $t/types/*.py ${D}${PTEST_PATH}/tests/types/
}
