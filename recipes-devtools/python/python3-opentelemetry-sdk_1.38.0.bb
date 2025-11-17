SUMMARY = "OpenTelemetry Python SDK"
HOMEPAGE = "https://github.com/open-telemetry/opentelemetry-python/tree/main/opentelemetry-sdk"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=86d3f3a95c324c9479bd8986968f4327"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "93df5d4d871ed09cb4272305be4d996236eedb232253e3ab864c8620f051cebe"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} += "\
	python3-opentelemetry-api (>=1.38.0) \
	python3-opentelemetry-semantic-conventions (>=0.59b0) \
	python3-typing-extensions (>=4.5.0) \
"

PYPI_PACKAGE = "opentelemetry_sdk"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
