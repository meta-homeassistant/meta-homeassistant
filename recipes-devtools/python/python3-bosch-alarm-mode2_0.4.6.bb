SUMMARY = "An async Python library for interacting with Bosch Alarm Panels supporting the 'Mode 2' API."
HOMEPAGE = "https://github.com/mag1024/bosch-alarm-mode2"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9a6bf8c3a15c0852aa2113b8d1cf4ca6"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatch-vcs-native python3-hatchling-native"
SRC_URI[sha256sum] = "1afafad06bb9d0a7fe42f0e4b19a7a0c5a0f310aec177e941ec6d7386d658ef2"

inherit pypi python_hatchling

PYPI_PACKAGE = "bosch_alarm_mode2"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
