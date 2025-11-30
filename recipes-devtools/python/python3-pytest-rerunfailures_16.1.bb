SUMMARY = "pytest plugin to re-run tests to eliminate flaky failures"
HOMEPAGE = "https://github.com/pytest-dev/pytest-rerunfailures"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=06238b648baf0545473491607f3093c5"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "c38b266db8a808953ebd71ac25c381cb1981a78ff9340a14bcb9f1b9bff1899e"

inherit pypi python_setuptools_build_meta ptest-python-pytest

PYPI_PACKAGE = "pytest_rerunfailures"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"

RDEPENDS:${PN} = "\
    python3-packaging \
    python3-pytest (>=7.4) \
"
