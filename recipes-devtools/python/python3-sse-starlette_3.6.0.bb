SUMMARY = "SSE plugin for Starlette"
HOMEPAGE = "https://github.com/sysid/sse-starlette"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=512780230e4edd77125d98c5f52abafe"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "623151d6c20dc0eebf1b3379c27faae91fff883bac7ab6665f16f46440a88b3a"

inherit pypi python_setuptools_build_meta ptest-python-pytest

RDEPENDS:${PN} = "\
	python3-anyio (>=4.7.0) \
    python3-starlette \
"
