SUMMARY = "GraphQL-core is a Python port of GraphQL.js,the JavaScript reference implementation for GraphQL."
HOMEPAGE = "https://github.com/graphql-python/graphql-core"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=73706fb002de2debc52328afd1688817"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI += "file://0001-relax-build-deps.patch"
SRC_URI[sha256sum] = "c08eec22f9e40f0bd61d805907e3b3b1b9a320bc606e23dc145eebca07c8fbab"

inherit pypi python_poetry_core ptest-python-pytest

RDEPENDS:${PN} = "python3-typing-extensions"

PYPI_PACKAGE = "graphql_core"
UPSTREAM_CHECK_PYPI_PACKAGE = "{$PYPI_PACKAGE}"
