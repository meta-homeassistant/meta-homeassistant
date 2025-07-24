SUMMARY = "An HTTP client for controlling a Bryant Evolution HVAC system"
HOMEPAGE = "https://github.com/danielsmyers/evolutionhttp"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=44cc82feb2b87bfb8bcca45b68b40e6d"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "561598864ad95540eed48e996536654d484d7e999adbdb446012e84fbc417753"

inherit pypi python_hatchling ptest-python-pytest

PYPI_PACKAGE = "evolutionhttp"
