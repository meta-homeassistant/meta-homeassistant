SUMMARY = "OpenTelemetry Semantic Conventions"
HOMEPAGE = "https://github.com/open-telemetry/opentelemetry-python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7a6db3f30d70202d5bf9fa4b69bc866ca6a30437287de6c510fb594878aed6b0"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} += "\
	python3-opentelemetry-api (>=1.38.0) \
	python3-typing-extensions (>=4.5.0) \
"

PYPI_PACKAGE = "opentelemetry_semantic_conventions"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
