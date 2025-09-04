SUMMARY = "A small and simple HTML table parser not requiring any external dependency."
HOMEPAGE = "https://github.com/schmijos/html-table-parser-python3"
LICENSE = "AGPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE;md5=c5edf65bb50f2284b1be0196d5a95c89"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "8e33c436c1011501b8d3ef95114587580e8e923ff59ee04903646654608369f4"

inherit pypi python_poetry_core

PYPI_PACKAGE = "html_table_parser_python3"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
