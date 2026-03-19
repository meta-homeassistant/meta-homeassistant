SUMMARY = "An async Python library for interacting with Bosch Alarm Panels supporting the 'Mode 2' API."
HOMEPAGE = "https://github.com/mag1024/bosch-alarm-mode2"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9a6bf8c3a15c0852aa2113b8d1cf4ca6"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatch-vcs-native python3-hatchling-native"
SRC_URI[sha256sum] = "c35815b1fc713e356db2943e07330eff0f2b773c122567b1b6f4ab064852bb4a"

inherit pypi python_hatchling

PYPI_PACKAGE = "bosch_alarm_mode2"
UPSTREAM_CHECK_PYPI_PACKAGE = "${PYPI_PACKAGE}"
