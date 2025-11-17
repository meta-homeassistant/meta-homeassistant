SUMMARY = "Functools like those found in stdlib"
HOMEPAGE = "https://github.com/jaraco/jaraco.functools"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=141643e11c48898150daa83802dbc65f"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "70f7e0e2ae076498e212562325e805204fc092d7b4c17e0e86c959e249701a9d"

inherit pypi python_setuptools_build_meta

DEPENDS += "python3-setuptools-scm-native"

PYPI_PACKAGE = "jaraco_functools"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "python3-more-itertools"

BBCLASSEXTEND = "native nativesdk"
