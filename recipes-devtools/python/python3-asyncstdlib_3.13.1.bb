SUMMARY = "The missing async toolbox"
HOMEPAGE = "https://github.com/maxfischer2781/asyncstdlib"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=57c5dc7606ef87c08c086a8ed7ce43f0"
RECIPE_MAINTAINER = "Tom Geelen <t.f.g.geelen@gmail.com>"

SRC_URI[sha256sum] = "f47564b9a3566f8f9172631d88c75fe074b0ce2127963b7265d310df9aeed03a"

inherit pypi python_flit_core

PYPI_PACKAGE = "asyncstdlib"
