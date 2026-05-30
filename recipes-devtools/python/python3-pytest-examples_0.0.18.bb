SUMMARY = "Pytest plugin for testing examples in docstrings and markdown files."
HOMEPAGE = "https://github.com/pydantic/pytest-examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=4914bbb433a7975b6b5c5f1bb48bb9d0"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "9a464f007f805b113677a15e2f8942ebb92d7d3eb5312e9a405d018478ec9801"

inherit pypi python_hatchling

RDEPENDS:${PN} = "\
	python3-pytest \
	python3-black \
	python3-ruff \
"

PYPI_PACKAGE = "pytest_examples"
