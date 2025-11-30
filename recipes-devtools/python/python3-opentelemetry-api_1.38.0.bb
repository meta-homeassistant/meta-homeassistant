SUMMARY = "OpenTelemetry Python API"
HOMEPAGE = "https://github.com/open-telemetry/opentelemetry-python"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f4c193b5e8acb0912b06ac5b16321908dd0843d75049c091487322284a3eea12"

inherit pypi python_hatchling ptest-python-pytest

PYPI_PACKAGE = "opentelemetry_api"

RDEPENDS:${PN} += "\
	python3-typing-extensions (>=4.5.0) \
"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
