SUMMARY = "Asynchronous library to control Rollease Acmeda Automate roller blinds via a version 1 Pulse Hub."
HOMEPAGE = "https://github.com/atmurray/aiopulse"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=d229da563da18fe5d58cd95a6467d584"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

DEPENDS = "python3-hatchling-native"
SRC_URI[sha256sum] = "0ccff30c5a13620696fa8d9862fe1b0c08dae62c1a6c805f149ed87a9e05cb07"

inherit pypi python_hatchling

PYPI_PACKAGE = "aiopulse"
