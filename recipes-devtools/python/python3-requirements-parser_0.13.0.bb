SUMMARY = "This is a small Python module for parsing Pip requirement files."
HOMEPAGE = "https://github.com/madpah/requirements-parser/#readme"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2b42edef8fa55315f34f2370b4715ca9"

SRC_URI[sha256sum] = "0843119ca2cb2331de4eb31b10d70462e39ace698fd660a915c247d2301a4418"

inherit pypi python_poetry_core ptest-python-pytest

RDEPENDS:${PN} = "python3-packaging"

PYPI_PACKAGE = "requirements_parser"
