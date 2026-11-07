SUMMARY = "An async Python library for interacting with Bosch Alarm Panels supporting the 'Mode 2' API."
HOMEPAGE = "https://github.com/mag1024/bosch-alarm-mode2"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=9a6bf8c3a15c0852aa2113b8d1cf4ca6"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatch-vcs-native python3-hatchling-native"
SRC_URI[sha256sum] = "d02205ad8ecf88832cd720e60219f8401bfa7a5d38586691f92cec96f80cc0c0"

inherit pypi python_hatchling
