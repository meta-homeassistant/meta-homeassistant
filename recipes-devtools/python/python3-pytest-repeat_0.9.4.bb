SUMMARY = "pytest plugin for repeating tests"
HOMEPAGE = "https://github.com/pytest-dev/pytest-repeat"
LICENSE = "MPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=2a0bb0f2949a8babbc1df9a81a569b25"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatch-vcs-native python3-hatchling-native"
SRC_URI[sha256sum] = "d92ac14dfaa6ffcfe6917e5d16f0c9bc82380c135b03c2a5f412d2637f224485"

inherit pypi python_hatchling

PYPI_PACKAGE = "pytest_repeat"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
RDEPENDS:${PN} = "python3-pytest"
