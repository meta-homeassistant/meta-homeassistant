SUMMARY = "A sane and fast Markdown parser with useful plugins and renderers"
HOMEPAGE = "https://github.com/lepture/mistune"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=7662a489238001edfceff24a3ce11cbd"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "708487c8a8cdd99c9d90eb3ed4c3ed961246ff78ac82f03418f5183ab70e398a"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN}-ptest = "\
    ${PN} \
    python3-pytest-cov \
"

PYPI_PACKAGE = "mistune"
