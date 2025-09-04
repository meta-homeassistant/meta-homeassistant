SUMMARY = "SSE plugin for Starlette"
HOMEPAGE = "https://github.com/sysid/sse-starlette"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=512780230e4edd77125d98c5f52abafe"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "7c8a800a1ca343e9165fc06bbda45c78e4c6166320707ae30b416c42da070926"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
	python3-anyio (>=4.7.0) \
"

PYPI_PACKAGE = "sse_starlette"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
