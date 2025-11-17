SUMMARY = "Useful decorators and context managers"
HOMEPAGE = "https://github.com/jaraco/jaraco.context"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=141643e11c48898150daa83802dbc65f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "9bae4ea555cf0b14938dc0aee7c9f32ed303aa20a3b73e7dc80111628792d1b3"

inherit pypi python_setuptools_build_meta

DEPENDS += "python3-setuptools-scm-native"

PYPI_PACKAGE = "jaraco_context"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

BBCLASSEXTEND = "native nativesdk"
