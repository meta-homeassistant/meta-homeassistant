SUMMARY = "Settings management using Pydantic"
HOMEPAGE = "https://github.com/pydantic/pydantic-settings"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9adde1a30a7e74a03e57e456551c19ae"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "06f0062169818d0f5524420a360d632d5857b83cffd4d42fe29597807a1614ee"

inherit pypi python_hatchling ptest-python-pytest

RDEPENDS:${PN} = "\
	python3-pydantic (>=2.7.0) \
	python3-python-dotenv (>=0.21.0) \
	python3-typing-extensions (>=0.4.0) \
"

PYPI_PACKAGE = "pydantic_settings"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
